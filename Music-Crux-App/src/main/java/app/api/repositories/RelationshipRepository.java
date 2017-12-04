package app.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import app.api.models.RelationshipType;
import app.api.models.db.Relationship;


public interface RelationshipRepository extends MongoRepository<Relationship, String>{
	
	public Relationship findByType(RelationshipType relationshipType);
	
	@Query("{$or: [{'entity1' :{'$ref' : 'entity' , '$id' : ?0}}, {'entity2' :{'$ref' : 'entity' , '$id' : ?0}}] }")
	public List<Relationship> findByEntity(String entityId);

}
