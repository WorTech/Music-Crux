package application.operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import application.discogsDB.models.Release;
import application.discogsDB.repositories.DiscogsArtistRepository;
import application.discogsDB.repositories.DiscogsReleaseRepository;

import models.Album;
import models.Artist;
import models.Entity;
import repositories.AlbumRepository;
import repositories.EntityRepository;

@Component
@Order(value = 3)
public class GenerateAlbumModels implements CommandLineRunner {

	@Autowired
	private DiscogsReleaseRepository discogsReleaseRepository;

	@Autowired 
	private DiscogsArtistRepository discogsArtistRepository;
	
	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private EntityRepository entityRepository;

	/**
	 * Uses the @discogsId to search the discogs' Artist collections and obtain the
	 * label for that @discogsId. The label is used to obtain the MusicCrux Entity
	 * which matches it.
	 * 
	 * @param discogsId
	 * @return Entity
	 */
	
	private Entity getCreatorEntityFor(String discogsArtistId) {
		application.discogsDB.models.Artist discogsArtist = discogsArtistRepository.findOne(discogsArtistId);
		return entityRepository.findByLabel(discogsArtist.getName());
	}

	/**
	 * Creates an Album from each of the releases in the discogs database
	 * 
	 * @return void
	 */
	private void constructAlbumsFromDiscogs() {

		for (Release release : discogsReleaseRepository.findAll()) {
			Album album = new Album();
			album.setCountry(release.getCountry());
			album.setGenres(release.getGenres());
			album.setReleaseDate(release.getReleased());
			album.setSubGenres(release.getStyles());
			album.setTitle(release.getTitle());

			List<Entity> creators = new ArrayList<>();

			release.getCreators().forEach((creator) -> {
				String discogsArtistId = String.valueOf(creator.getDiscogsId());
				creators.add(getCreatorEntityFor(discogsArtistId));
			});

			album.setCreators(creators);
			
		}
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
