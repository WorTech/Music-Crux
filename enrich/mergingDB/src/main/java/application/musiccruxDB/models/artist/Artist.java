package application.musiccruxDB.models.artist;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import application.musiccruxDB.models.entity.Entity;

@Document
public class Artist {
	@Id
	private BigInteger id;
	@Indexed
	private String label;
	@DBRef
	private Entity entity;

	public Artist() {

	}

	public Artist(BigInteger id, String label, Entity entity) {
		this.id = id;
		this.label = label;
		this.entity = entity;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", label=" + label + "]";
	}

}
