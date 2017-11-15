package application.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.api.models.RelationshipType;
import application.api.models.db.Entity;
import application.api.models.db.Relationship;


public interface RelationshipRepository extends MongoRepository<Relationship, String>{
	
	public Relationship findByType(RelationshipType relationshipType);

	public List<Relationship> findBySourceEntity(Entity sourceEntity);
}
