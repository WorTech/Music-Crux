package application.api.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import application.api.models.Molecule;
import application.api.models.db.Entity;
import application.api.models.db.Relationship;

@Repository
public class DummyMoleculesRepository {
	private static Molecule molecule;
	private static List<Entity> entities;
	private static List<Relationship> relationships;

	static {
		entities = DummyEntityRepository.getEntities(); // get the static DummyEntitys.
		relationships = DummyRelationshipRepository.getRelationships();

		molecule = new Molecule(entities, relationships);
	}

	public static Molecule getMolecule() {
		return molecule;
	}
}
