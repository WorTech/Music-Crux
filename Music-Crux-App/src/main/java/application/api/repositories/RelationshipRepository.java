package application.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.api.models.db.Relationship;
import application.api.models.db.RelationshipType;


public interface RelationshipRepository extends MongoRepository<Relationship, String>{
	
	public Relationship findByType(RelationshipType relationshipType);
}
