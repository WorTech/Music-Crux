package application.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import application.api.models.RelationshipType;
import application.api.models.db.Entity;
import application.api.models.db.Relationship;


public interface RelationshipRepository extends MongoRepository<Relationship, String>{
	
	public Relationship findByType(RelationshipType relationshipType);
	
	
	//@Query//("{'$or': [{'entity1':?0}, {'entity2':?1}]}")
	//public List<Relationship> findByEntity1OrEntity2(Entity entity1, Entity entity2);
	//@Query("{'entity1':{'label':?0}}")
	public List<Relationship> findByEntity1OrEntity2(String id);
	//public List<Relationship> findByEntity1LabelContaining(String label);
}
