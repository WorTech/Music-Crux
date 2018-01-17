package application.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import models.Entity;
import models.Artist;
import models.EntityType;
import repositories.ArtistRepository;
import repositories.EntityRepository;

/**
 * Uses the Entity Repository and generates a Artist of the entities of type
 * Artist
 *
 */
@Component
@Order(value = 2)
public class GenerateArtistModels implements CommandLineRunner {

	@Autowired
	private EntityRepository entityRepository;

	@Autowired
	private ArtistRepository db;

	/**
	 * Creates an artist from each of the Entities in the Musiccrux database
	 * 
	 * @return void
	 */
	private void constructArtistFromEntity() {
		for (Entity entity : entityRepository.findByType(EntityType.ARTIST)) {
			// Artist artist = new Artist(entity.getId(), entity.getLabel());
			Artist artist = new Artist();
			artist.setEntity(entity);
			artist.setLabel(entity.getLabel());
			db.save(artist);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		constructArtistFromEntity();
	}

}
