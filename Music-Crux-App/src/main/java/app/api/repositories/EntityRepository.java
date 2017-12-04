package app.api.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import app.api.models.db.Entity;

public interface EntityRepository extends MongoRepository<Entity, String>{
	
	public Entity findByLabel(String label);
	public List<Entity> findByLabelContainingIgnoreCase(String label, Pageable pageable);
}
