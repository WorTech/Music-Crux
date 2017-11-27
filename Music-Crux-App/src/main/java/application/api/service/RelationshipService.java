package application.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.api.models.db.Entity;
import application.api.models.db.Relationship;
import application.api.models.ui.RelationshipUI;
import application.api.repositories.EntityRepository;
import application.api.repositories.RelationshipRepository;

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
