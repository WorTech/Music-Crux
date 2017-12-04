package application.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import application.discogsDB.models.Artist;
import application.discogsDB.repositories.DiscogsArtistRepository;
import application.musiccruxDB.models.entity.Entity;
import application.musiccruxDB.models.entity.EntityType;
import application.musiccruxDB.repositories.EntityRepository;

/*
 * Read the Discogs database and create Entities collection from the Artists collection.
 */

@Component
@Order(value = 1)
public class GenerateEntityModels implements CommandLineRunner {
	
	@Autowired
	private DiscogsArtistRepository discogsArtistRepository;

	@Autowired
	private EntityRepository db;

	/**
	 * Creates an entity from each of the Artists in the Discogs database
	 * 
	 * @return void
	 */
	private void constructEntityFromArtist() {
		
		for (Artist artist : discogsArtistRepository.findAll()) {
			Entity entity = new Entity();
			entity.setLabel(artist.getName());

			if (artist.getMembers() == null) {
				entity.setType(EntityType.ARTIST);
			} else { // "artists" with members are actually bands
				entity.setType(EntityType.BAND);
			}
			System.out.println(entity);
			db.save(entity);
		}
	}

	public void run(String... args) throws Exception {
		constructEntityFromArtist();
	}
}