package application.musiccruxDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.musiccruxDB.models.relationship.Relationship;

public interface RelationshipRepository extends MongoRepository<Relationship, String> {
	
	public void deleteAll();
}