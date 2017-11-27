package application.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.api.models.db.Entity;
import application.api.models.db.Relationship;
import application.api.models.ui.RelationshipUI;
import application.api.repositories.EntityRepository;
import application.api.repositories.RelationshipRepository;

@RestController
@RequestMapping("/api")
public class RelationshipController {
	
	@Autowired
	EntityRepository entityRepository;
	@Autowired
	RelationshipRepository relationshipRepository;
	
	@RequestMapping(value = "/relationship", method = RequestMethod.GET)
	public ResponseEntity<List<RelationshipUI>> getRelationshipsContainingLabel(@RequestParam("label") String label) {
		System.out.println(label);
		Entity entity1 = entityRepository.findByLabel(label);
		System.out.println("ENTITY 1 " + entity1.getId());
		
		List<Relationship> relationships = relationshipRepository.findByEntity1OrEntity2(entity1.getId());
		System.out.println("relationships: " + relationships);
		List<RelationshipUI> relationshipsUI = RelationshipUI.dbModelToUiModel(relationships);
		
		HttpStatus status = relationships == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return new ResponseEntity<List<RelationshipUI>>(relationshipsUI, status);
	}
}
