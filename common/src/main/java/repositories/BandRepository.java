package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Band;

public interface BandRepository extends MongoRepository<Band, String> {
	
	public Band findByLabel(String label);
}