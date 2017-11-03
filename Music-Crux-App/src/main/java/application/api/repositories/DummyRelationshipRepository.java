package application.api.repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import application.api.models.db.Entity;
import application.api.models.db.EntityType;
import application.api.models.db.Relationship;
import application.api.models.db.RelationshipType;

@Repository
public class DummyRelationshipRepository {
	private static List<Relationship> relationships;

	static {
		Entity entityA1 = new Entity(new BigInteger("123"), EntityType.ARTIST, "ARTIST NUMBER 1");
		Entity entityB = new Entity(new BigInteger("456"), EntityType.BAND, "BAND NUMBER 1");
		Entity entityA2 = new Entity(new BigInteger("789"), EntityType.ARTIST, "ARTIST NUMBER 2");
		
		relationships = new ArrayList<>();
		relationships.add(new Relationship(RelationshipType.FEATURED, entityB, entityA1));
		relationships.add(new Relationship(RelationshipType.FEATURED, entityB, entityA2));
	}

	public static List<Relationship> getRelationships() {
		return relationships;
	}

}
