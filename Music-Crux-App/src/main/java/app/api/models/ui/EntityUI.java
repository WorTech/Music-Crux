package app.api.models.ui;

import java.util.ArrayList;
import java.util.List;

import app.api.models.EntityType;
import app.api.models.db.Entity;

public class EntityUI {

	// feel free to change to int or long if that fits your model better
	private String id;

	private EntityType type;

	// artist name, band name, etc
	private String label;

	public static EntityUI dbModelToUiModel(Entity entity) {
		if (entity == null )
			return null;
		
		return new EntityUI(entity.getId(), entity.getType(), entity.getLabel());
	}

	public static List<EntityUI> dbModelToUiModel(List<Entity> entities) {

		List<EntityUI> entityUIs = new ArrayList<>();

		for (Entity entity : entities) {
			if (entity != null) {
				EntityUI entityUI = new EntityUI(entity.getId(), entity.getType(), entity.getLabel());
				entityUIs.add(entityUI);
			}
		}
		return entityUIs;
	}

	public EntityUI() {

	}

	public EntityUI(String id, EntityType type, String label) {
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

}
