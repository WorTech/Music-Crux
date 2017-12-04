package application.musiccruxDB.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.musiccruxDB.models.entity.Entity;
import application.musiccruxDB.models.entity.EntityType;

public interface EntityRepository extends MongoRepository<Entity, String> {
	public Entity findByLabel(String label);
	public Entity findById(BigInteger id);
	
	
	public List<Entity> findByType(EntityType entityType);
	
	public void deleteAll();
}