package application.api.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import application.api.models.Relationship;
import application.api.models.RelationshipType;

@Repository
public class DummyRelationshipRepository {
	private static List<Relationship> relationships;

	static {
		relationships = new ArrayList<>();
		relationships.add(new Relationship(RelationshipType.FEATURED, 0, 1));
		relationships.add(new Relationship(RelationshipType.FEATURED, 2, 1));
	}

	public static List<Relationship> getRelationships() {
		return relationships;
	}

}
