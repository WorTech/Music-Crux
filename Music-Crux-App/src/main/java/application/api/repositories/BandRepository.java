package application.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.api.models.db.Band;

public interface BandRepository extends MongoRepository<Band, String> {
	
	public Band findByLabel(String label);
}
