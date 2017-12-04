package app.api.models.ui;

import java.util.ArrayList;
import java.util.List;

import app.api.models.db.Molecule;

public class MoleculeUI {
	private List<EntityUI> entities = new ArrayList<>();
	private List<RelationshipUI> relationships = new ArrayList<>();
		
	public static MoleculeUI dbModelToUiModel(Molecule molecule) {
		
		MoleculeUI moleculeUI = new MoleculeUI();
		List<RelationshipUI> relationshipUIs = RelationshipUI.dbModelToUiModel(molecule.getRelationships());
		List<EntityUI> entityUIs = EntityUI.dbModelToUiModel(molecule.getEntities());
		moleculeUI.setRelationships(relationshipUIs);
		moleculeUI.setEntities(entityUIs);
		
		return moleculeUI;
	}
	
	public MoleculeUI() {
	}
	
	public MoleculeUI (List<EntityUI>entities, List<RelationshipUI> relationships) {
		this.entities = entities;
		this.relationships = relationships;
	}
	
	public List<EntityUI> getEntities() {
		return entities;
	}
	
	public void setEntities(List<EntityUI> entities) {
		this.entities = entities;
	}
	
	public List<RelationshipUI> getRelationships() {
		return relationships;
	}
	
	public void setRelationships(List<RelationshipUI> relationships) {
		this.relationships = relationships;
	}
	
	
	
	
}