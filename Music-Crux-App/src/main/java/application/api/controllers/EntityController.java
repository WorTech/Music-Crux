package application.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.api.models.ui.EntityUI;
import application.api.models.ui.MoleculeUI;
import application.api.service.EntityService;

@RestController
@RequestMapping("/api")
public class EntityController {

	@Autowired
	EntityService entityService;
	
	@RequestMapping(value = "/entity", method = RequestMethod.GET)
	public ResponseEntity<List<EntityUI>> createMoleculeFromLabels(@RequestParam("label") String label, 
			@RequestParam("limit") int limit) {
		
		List<EntityUI> entities = entityService.getEntitySearchResults(label, limit);
		HttpStatus status = entities == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return new ResponseEntity<List<EntityUI>>(entities, status);
	}
}
