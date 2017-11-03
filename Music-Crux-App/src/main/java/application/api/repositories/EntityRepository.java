package application.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.api.models.db.Entity;

public interface EntityRepository extends MongoRepository<Entity, String>{
	
	public Entity findByLabel(String label);
}
