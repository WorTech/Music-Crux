package application.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import application.api.models.RelationshipType;
import application.api.models.db.Relationship;


public interface RelationshipRepository extends MongoRepository<Relationship, String>{
	
	public Relationship findByType(RelationshipType relationshipType);
	
	@Query("{$or: [{'entity1' :{'$ref' : 'entity' , '$id' : ?0}}, {'entity2' :{'$ref' : 'entity' , '$id' : ?0}}] }")
	public List<Relationship> findByEntity(String entity1Id);

}
