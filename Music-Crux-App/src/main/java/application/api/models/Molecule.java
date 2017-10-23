package application.api.models;
import java.util.ArrayList;
import java.util.List;

public class Molecule {
	private List<Entity> entities = new ArrayList<>();
	private List<Relationship> relationships = new ArrayList<>();
		
	public Molecule() {
	}
	
	public Molecule(List<Entity>entities, List<Relationship> relationships) {
		this.entities = entities;
		this.relationships = relationships;
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	
	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	
	public List<Relationship> getRelationships() {
		return relationships;
	}
	
	public void setRelationships(List<Relationship> relationships) {
		this.relationships = relationships;
	}
	
	
	
	
}
