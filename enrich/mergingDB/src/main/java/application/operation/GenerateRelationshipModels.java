package application.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import application.discogsDB.models.Artist;
import application.discogsDB.repositories.DiscogsArtistRepository;
import application.musiccruxDB.models.entity.Entity;
import application.musiccruxDB.models.entity.EntityType;
import application.musiccruxDB.models.relationship.Relationship;
import application.musiccruxDB.models.relationship.RelationshipType;
import application.musiccruxDB.repositories.EntityRepository;
import application.musiccruxDB.repositories.RelationshipRepository;

/**
 * Creates a relationship collection between two entities in the MusicCrux
 */
@Component
@Order(value = 3)
public class GenerateRelationshipModels implements CommandLineRunner {

	@Autowired
	private DiscogsArtistRepository discogsArtistRepository;
	@Autowired
	private EntityRepository entityRepository;
	@Autowired
	private RelationshipRepository db;

	/**
	 * This function leverages the entity collection of the MusicCrux database as
	 * well as the Discogs "Artist" collection to creates a ARTIST_BAND
	 * relationship.
	 * 
	 * From the entities of type BAND within the MusicCrux database, look through
	 * the Discogs database for 'artists'(actually Bands) which match that entity
	 * and create a 'ARTIST_BAND' relationship between the Band and Artist entities
	 * 
	 * Note: In the Discogs database, the 'artist' collection contains both bands
	 * and actual artists.
	 */
	private void createArtistBandRelationship() {

		for (Entity bandEntity : entityRepository.findByType(EntityType.BAND)) {

			Artist discogsArtist = discogsArtistRepository.findByName(bandEntity.getLabel());// Find the band (marked as 'artist' in discogs)

			if (discogsArtist != null && discogsArtist.getMembers() != null) { // Found an discogsArtist (in reality this is a Band) with members

				String[] memberLabels = discogsArtist.getMembers().getNames();
				for (String label : memberLabels) {
					Entity artistEntity = entityRepository.findByLabel(label);

					Relationship relationship = new Relationship();
					relationship.setEntity1(artistEntity);
					relationship.setEntity2(bandEntity);
					relationship.setType(RelationshipType.ARTIST_BAND);
					db.save(relationship);
					System.out.println(" (ARTIST_BAND) relationship made between " + label + " AND " + bandEntity.getLabel() );
				}
			}
		}
	}

	public void run(String... args) throws Exception {
		createArtistBandRelationship();
	}
}