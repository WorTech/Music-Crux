package application.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import application.api.models.db.Entity;
import application.api.models.db.Relationship;
import application.api.models.db.RelationshipType;


public interface RelationshipRepository extends MongoRepository<Relationship, String>{
	
	public Relationship findByType(RelationshipType relationshipType);

	public List<Relationship> findBySourceEntity(Entity sourceEntity);
}
