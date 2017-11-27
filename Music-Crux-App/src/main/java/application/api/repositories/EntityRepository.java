package application.api.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import application.api.models.db.Entity;

public interface EntityRepository extends MongoRepository<Entity, String>{
	
	public Entity findByLabel(String label);
	public List<Entity> findByLabelContaining(String label, Pageable pageable);
}
