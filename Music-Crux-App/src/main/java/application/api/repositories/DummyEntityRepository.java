package application.api.repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import application.api.models.db.Entity;
import application.api.models.db.EntityType;
import application.api.models.db.Relationship;
import application.api.models.db.RelationshipType;

@Repository
public class DummyEntityRepository {

	private static List<Entity> entities;

	static {
		entities = new ArrayList<Entity>();
		entities.add(new Entity(new BigInteger("123"), EntityType.ARTIST, "ARTIST NUMBER 1"));
		entities.add(new Entity(new BigInteger("456"), EntityType.BAND, "BAND NUMBER 1"));
		entities.add(new Entity(new BigInteger("789"), EntityType.ARTIST, "ARTIST NUMBER 2"));
	}

	public Entity getEntityById(int id) {
		return entities.get(id);
	}

	public Entity getRemoveById(int id) {
		return entities.remove(id);
	}

	public void updateEntityById(int id, Entity entity) {
		Entity e = entities.get(id);
		e.setLabel(e.getLabel());
		e.setType(e.getType());

	}

	public void insertEntity(Entity entity) {
		entities.add(entity);
	}

	public static List<Entity> getEntities() {
		return entities;
	}

}
