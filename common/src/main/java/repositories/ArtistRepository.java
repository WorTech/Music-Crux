package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Artist;

public interface ArtistRepository extends MongoRepository<Artist, String> {
	
	public Artist findByLabel(String label);
}
