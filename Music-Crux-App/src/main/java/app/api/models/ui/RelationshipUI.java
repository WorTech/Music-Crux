package app.api.models.ui;

import java.util.ArrayList;
import java.util.List;

import app.api.models.RelationshipType;
import app.api.models.db.Relationship;

public class RelationshipUI {

	private RelationshipType type;
	private String entity1Index;
	private String entity2Index;

	public static RelationshipUI dbModelToUiModel(Relationship relationship) {
		RelationshipUI relationshipUI = new RelationshipUI();
		relationshipUI.setType(relationship.getType());
		relationshipUI.setEntity1Index(relationship.getEntity1().getId());
		relationshipUI.setEntity2Index(relationship.getEntity2().getId());

		return relationshipUI;
	}

	public static List<RelationshipUI> dbModelToUiModel(List<Relationship> relationships) {

		List<RelationshipUI> relationshipUIs = new ArrayList<>();

		for (Relationship relationship : relationships) {

			RelationshipUI relationshipUI = new RelationshipUI();
			relationshipUI.setType(relationship.getType());
			relationshipUI.setEntity1Index(relationship.getEntity1().getId());
			relationshipUI.setEntity2Index(relationship.getEntity2().getId());

			relationshipUIs.add(relationshipUI);
		}

		return relationshipUIs;
	}

	public RelationshipUI() {

	}

	public RelationshipUI(RelationshipType type, String entity1Index, String entity2Index) {
		this.type = type;
		this.entity1Index = entity1Index;
		this.entity2Index = entity2Index;
	}

	public RelationshipType getType() {
		return type;
	}

	public void setType(RelationshipType type) {
		this.type = type;
	}

	public String getEntity1Index() {
		return entity1Index;
	}

	public void setEntity1Index(String entity1Index) {
		this.entity1Index = entity1Index;
	}

	public String getEntity2Index() {
		return entity2Index;
	}

	public void setEntity2Index(String entity2Index) {
		this.entity2Index = entity2Index;
	}

}