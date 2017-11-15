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
public class EntityService {

	@Autowired
	EntityRepository entityRepository;

	@Autowired
	RelationshipRepository relationshipRepository;

	/**
	 * Creates a molecule from the provided labels.
	 * The Molecule consists of the entities and relationships corresponding to the labels
	 * @param entities
	 * @return Molecule
	 */
	public MoleculeUI createMoleculeFromLabels(List<String> labels) {
		
		List<Molecule> molecules = new ArrayList<>();
		
		for (String label : labels) {
			
			Entity sourceEntity = entityRepository.findByLabel(label);
			if (sourceEntity == null) {
				continue;
			}
			
			List<Relationship> relationships = relationshipRepository.findBySourceEntity(sourceEntity);
			List<Entity> entities = new ArrayList<>();
					
			for (Relationship relationship : relationships) {
				entities.add(relationship.getTargetEntity());
			}
			
			entities.add(sourceEntity); // The source entity should be added as well;
			
			molecules.add(new Molecule(entities, relationships));
		}
		
		
		return MoleculeUI.dbModelToUiModel(Molecule.join(molecules));
	}
}
