package application.api.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.api.models.db.Entity;
import application.api.models.db.Molecule;
import application.api.models.db.Relationship;
import application.api.models.ui.MoleculeUI;
import application.api.repositories.EntityRepository;
import application.api.repositories.RelationshipRepository;

@Service
public class MoleculeService {

	@Autowired
	EntityRepository entityRepository;

	@Autowired
	RelationshipRepository relationshipRepository;

	public MoleculeUI createMoleculeFor(String entityId, int depth) {

		HashSet<String> visited = new HashSet<>();
		Molecule molecule = new Molecule();

		if (depth <= 0) {
			Entity entity = entityRepository.findOne(entityId);
			molecule.addEntity(entity);
		} else {
			populateMolecule(entityId, depth, visited, molecule);
		}

		return MoleculeUI.dbModelToUiModel(molecule);
	}

	public void populateMolecule(String entityId, int depth, HashSet<String> visited, Molecule molecule) {

		if (depth <= 0 || visited.contains(entityId)) {
			return;
		}

		depth -= 1;

		Entity entity = entityRepository.findOne(entityId);
		List<Relationship> relationships = relationshipRepository.findByEntity(entityId);
		molecule.addEntity(entity);
		molecule.addRelationships(relationships);
		visited.add(entityId);

		for (Relationship relationship : relationships) {

			if (!visited.contains(relationship.getEntity1().getId())) {
				molecule.addEntity(relationship.getEntity1());
				populateMolecule(relationship.getEntity1().getId(), depth, visited, molecule);
			}
			if (!visited.contains(relationship.getEntity2().getId())) {
				molecule.addEntity(relationship.getEntity2());
				populateMolecule(relationship.getEntity2().getId(), depth, visited, molecule);
			}
		}
	}

}
