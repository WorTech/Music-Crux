package application.api.models.ui;

import java.util.ArrayList;
import java.util.List;

import application.api.models.RelationshipType;
import application.api.models.db.Relationship;

public class RelationshipUI {

	private RelationshipType type;
	private String sourceEntityIndex;
	private String targetEntityIndex;

	public static RelationshipUI dbModelToUiModel(Relationship relationship) {
		RelationshipUI relationshipUI = new RelationshipUI();
		relationshipUI.setType(relationship.getType());
		relationshipUI.setSource(relationship.getSourceEntity().getId());
		relationshipUI.setTarget(relationship.getTargetEntity().getId());
		
		return relationshipUI;
	}
	
	public static List<RelationshipUI> dbModelToUiModel(List<Relationship> relationships) {
		
		List<RelationshipUI> relationshipUIs = new ArrayList<>();
		
		for(Relationship relationship: relationships) {
			
			RelationshipUI relationshipUI = new RelationshipUI();
			relationshipUI.setType(relationship.getType());
			relationshipUI.setSource(relationship.getSourceEntity().getId());
			relationshipUI.setTarget(relationship.getTargetEntity().getId());
			
			relationshipUIs.add(relationshipUI);
		}
		
		return relationshipUIs;
	}
	
	public RelationshipUI() {

	}

	public RelationshipUI(RelationshipType type, String sourceEntityIndex, String targetEntityIndex) {
		this.type = type;
		this.sourceEntityIndex = sourceEntityIndex;
		this.targetEntityIndex = targetEntityIndex;
	}

	public RelationshipType getType() {
		return type;
	}

	public void setType(RelationshipType type) {
		this.type = type;
	}

	public String getSource() {
		return sourceEntityIndex;
	}

	public void setSource(String sourceEntityIndex) {
		this.sourceEntityIndex = sourceEntityIndex;
	}

	public String getTarget() {
		return targetEntityIndex;
	}

	public void setTarget(String targetEntityIndex) {
		this.targetEntityIndex = targetEntityIndex;
	}

}