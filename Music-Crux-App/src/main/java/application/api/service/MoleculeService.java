package application.api.service;

import java.util.ArrayList;
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

	public MoleculeUI getMoleculeFor(String name, int limit) {

		Molecule molecule = _getMoleculeFor(name, limit);

		return MoleculeUI.dbModelToUiModel(molecule);

	}

	private Molecule _getMoleculeFor(String name, int limit) {

		Molecule molecule;
		Entity sourceEntity = entityRepository.findByLabel(name);
		List<Relationship> relationships = new ArrayList<>();
		List<Entity> entities = new ArrayList<>();

		if (limit == 0) {
			entities.add(sourceEntity);
			return new Molecule(entities, relationships);
		} else {
			molecule = generateMoleculeForEntity(sourceEntity);

			for (Relationship relationship : molecule.getRelationships()) {
				Entity targetEntity = relationship.getTargetEntity();
				molecule = Molecule.join(molecule, _getMoleculeFor(targetEntity.getLabel(), --limit));
			}
		}

		return molecule;

	}

	private Molecule generateMoleculeForEntity(Entity sourceEntity) {

		List<Relationship> relationships = relationshipRepository.findBySourceEntity(sourceEntity);
		List<Entity> entities = new ArrayList<>();

		// populate the entities list with the targets of the provided sourceEntity
		for (Relationship relationship : relationships) {
			entities.add(relationship.getTargetEntity());
		}

		return new Molecule(entities, relationships);

	}

}
