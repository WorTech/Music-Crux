package app.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.api.models.ui.RelationshipUI;
import models.Entity;
import models.Relationship;
import repositories.EntityRepository;
import repositories.RelationshipRepository;


@Service
public class RelationshipService {
	
	@Autowired
	EntityRepository entityRepository;
	
	@Autowired
	RelationshipRepository relationshipRepository;
	
	public List<RelationshipUI> findByLabel(String label) {
		
		Entity entity= entityRepository.findByLabel(label);
		List<Relationship> relationships = relationshipRepository.findByEntity(entity.getId());
		
		return RelationshipUI.dbModelToUiModel(relationships);
	}
	
}
