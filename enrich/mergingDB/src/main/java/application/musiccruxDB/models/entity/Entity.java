package application.musiccruxDB.models.entity;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Entity {

	@Id
	private BigInteger id;
	@Indexed
	private String label; // artist name, band name, etc
	@Indexed
	private EntityType type;

	public Entity() {

	}

	public Entity(BigInteger id, EntityType type, String label) {
		this.id = id;
		this.type = type;
		this.label = label;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
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