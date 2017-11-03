package application.api.models.db;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Relationship {
	@Indexed
	private RelationshipType type;

	@DBRef
	private Entity targetEntity, sourceEntity;

	public Relationship() {
	}
	
	public Relationship(RelationshipType type, Entity targetEntity, Entity sourceEntity) {
		this.type = type;
		this.targetEntity = targetEntity;
		this.sourceEntity = sourceEntity;
	}

	public Entity getTargetEntity() {
		return targetEntity;
	}

	public void setTargetEntity(Entity targetEntity) {
		this.targetEntity = targetEntity;
	}

	public Entity getSourceEntity() {
		return sourceEntity;
	}

	public void setSourceEntity(Entity sourceEntity) {
		this.sourceEntity = sourceEntity;
	}

	public RelationshipType getType() {
		return type;
	}

	public void setType(RelationshipType type) {
		this.type = type;
	}

}