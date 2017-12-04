package app.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.api.models.db.Entity;
import app.api.models.db.Relationship;
import app.api.models.ui.RelationshipUI;
import app.api.repositories.EntityRepository;
import app.api.repositories.RelationshipRepository;

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
