package application.api.models.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import application.api.models.EntityType;

@Document
public class Entity {

	@Id
	private String id;
	@Indexed
	private String label; // artist name, band name, etc
	@Indexed
	private EntityType type;

	public Entity() {

	}

	public Entity(String id, EntityType type, String label) {
		this.id = id;
		this.type = type;
		this.label = label;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EntityType getType() {
		return type;
	}

	public void setType(EntityType type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", label=" + label + ", type=" + type + "]";
	}

}