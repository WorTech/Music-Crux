package application.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.api.models.ui.RelationshipUI;
import application.api.service.RelationshipService;

@RestController
@RequestMapping("/api")
public class RelationshipController {
	
	@Autowired

	RelationshipService relationshipService;
	
	@RequestMapping(value = "/relationship", method = RequestMethod.GET)
	public ResponseEntity<List<RelationshipUI>> getRelationshipsContainingLabel(@RequestParam("label") String label){
		
		List<RelationshipUI> relationships = relationshipService.findByLabel(label);
		
		HttpStatus status = relationships == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return new ResponseEntity<List<RelationshipUI>>(relationships, status);
	}
}

