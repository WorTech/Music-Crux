package app.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.api.models.db.Band;

public interface BandRepository extends MongoRepository<Band, String> {
	
	public Band findByLabel(String label);
}
