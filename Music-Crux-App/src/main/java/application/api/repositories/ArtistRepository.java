package application.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.api.models.db.Artist;

public interface ArtistRepository extends MongoRepository<Artist, String> {
	
	public Artist findByLabel(String label);
}
