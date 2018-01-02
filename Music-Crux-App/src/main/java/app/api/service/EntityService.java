package app.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import app.api.models.ui.EntityUI;
import models.Entity;
import repositories.EntityRepository;
import repositories.RelationshipRepository;


@Service
public class EntityService {

	@Autowired
	EntityRepository entityRepository;

	@Autowired
	RelationshipRepository relationshipRepository;

	// TODO: Update this function to reflect the changes to the Relationship models
	//
	
	/**
	 * Creates a molecule from the provided labels.
	 * The Molecule consists of the entities and relationships corresponding to the labels
	 * @param entities
	 * @return Molecule
	 */
	public List<EntityUI> getEntitySearchResults(String name, int limit){
		List<Entity> searchResults = new ArrayList<>();
		searchResults = entityRepository.findByLabelContainingIgnoreCase(name, new PageRequest(0,limit));
		return EntityUI.dbModelToUiModel(searchResults);
	}
}
