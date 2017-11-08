package application.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.api.models.Molecule;
import application.api.models.db.Entity;
import application.api.models.db.Relationship;
import application.api.repositories.EntityRepository;
import application.api.repositories.RelationshipRepository;

@Service
public class EntityService{


	@Autowired 
	EntityRepository entityRepository;
	
	@Autowired
	RelationshipRepository relationshipRepository;

	public Molecule createMoleculeFromEntity(Entity entity, Integer depth) {
		Entity sourceEntity = entityRepository.findByLabel(entity.getLabel());
		List<Relationship> relationships = relationshipRepository.findBySourceEntity(sourceEntity);
		//List<Entity>
		
		//Molecule molecule
		
		return null;
	}

	public Molecule createMoleculeFromEntities(List<Entity> entities, Integer depth) {
		// TODO Auto-generated method stub
		return null;
	}
}
