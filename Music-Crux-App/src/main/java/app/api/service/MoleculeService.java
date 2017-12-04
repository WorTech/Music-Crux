package app.api.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.api.models.db.Entity;
import app.api.models.db.Molecule;
import app.api.models.db.Relationship;
import app.api.models.ui.MoleculeUI;
import app.api.repositories.EntityRepository;
import app.api.repositories.RelationshipRepository;

@Service
public class MoleculeService {

	@Autowired
	EntityRepository entityRepository;

	@Autowired
	RelationshipRepository relationshipRepository;
	
	/**
	 * Returns a molecule for the specified @entityId .
	 * 
	 * @param entityId : id of the current entity being searched
	 * @param depth    : The depth to search
	 * @return : MoleculeUI
	 */
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

	/**
	 * Recursively searches the @entityId for a depth of @depth > 1. The resulting entities and
	 * relationships are appended to the provided molecule.
	 * 
	 * @param entityId : id of the current entity being searched
	 * @param depth    : The depth of the search
	 * @param visited  : hashed ids of the visited entities
	 * @param molecule : The molecule being modified
	 */
	private void populateMolecule(String entityId, int depth, HashSet<String> visited, Molecule molecule) {

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
				if (depth == 0) { // Once the end has been reached, the connected entity should be added to the
									// molecule but it shouldn't recursively.
					molecule.addEntity(relationship.getEntity1());
					visited.add(relationship.getEntity1().getId());
				} else {
					populateMolecule(relationship.getEntity1().getId(), depth, visited, molecule);
				}
			}
			if (!visited.contains(relationship.getEntity2().getId())) {
				if (depth == 0) {
					molecule.addEntity(relationship.getEntity2());
					visited.add(relationship.getEntity2().getId());
				} else {
					populateMolecule(relationship.getEntity2().getId(), depth, visited, molecule);
				}
			}
		}
	}

}
