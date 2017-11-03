package application.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.api.models.Molecule;
import application.api.models.db.Entity;
import application.api.repositories.EntityRepository;

@Service
public class EntityService{


	@Autowired 
	EntityRepository entityRepository;

	public Molecule createMoleculeFromEntity(Entity entity, Integer depth) {
		// TODO Auto-generated method stub
		return null;
	}

	public Molecule createMoleculeFromEntities(List<Entity> entities, Integer depth) {
		// TODO Auto-generated method stub
		return null;
	}
}
