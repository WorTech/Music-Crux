package com.db.mongo.repositories;

import com.db.mongo.models.Relationship;
import com.db.mongo.models.RelationshipType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
/**
 * Repository to create queries to interact with a specific collection
 */
@CrossOrigin
public interface RelationshipRepository extends MongoRepository<Relationship, String>{
	
	public List<Relationship> findByType(RelationshipType relationshipType);
	//allows the queries to be in upper and lower case
	@Query("{$or: [{'entityA' :{'$ref' : 'artist' , '$id' : ?0}}, {'entityB' :{'$ref' : 'band' , '$id' : ?0}}] }")
	public List<Relationship> findByEntity(String entityId);
}