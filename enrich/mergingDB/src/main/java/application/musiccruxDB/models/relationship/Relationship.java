package application.musiccruxDB.models.relationship;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import application.musiccruxDB.models.entity.Entity;

@Document
public class Relationship {
	@Indexed
	private RelationshipType type;

	@DBRef
	private Entity entity1, entity2;

	public Relationship() {
	}

	public Entity getEntity1() {
		return entity1;
	}

	public void setEntity1(Entity entity1) {
		this.entity1 = entity1;
	}

	public Entity getEntity2() {
		return entity2;
	}

	public void setEntity2(Entity entity2) {
		this.entity2 = entity2;
	}

	public RelationshipType getType() {
		return type;
	}

	public void setType(RelationshipType type) {
		this.type = type;
	}

}