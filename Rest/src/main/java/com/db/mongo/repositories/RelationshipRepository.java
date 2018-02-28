package com.db.mongo.repositories;

import java.util.List;

import com.db.mongo.models.Relationship;
import com.db.mongo.models.RelationshipType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface RelationshipRepository extends MongoRepository<Relationship, String>{
	
	public List<Relationship> findByType(RelationshipType relationshipType);
	
	@Query("{$or: [{'entityA' :{'$ref' : 'entity' , '$id' : ?0}}, {'entityB' :{'$ref' : 'entity' , '$id' : ?0}}] }")
	public List<Relationship> findByEntity(String entityId);
}