package application.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.api.models.Entity;
import application.api.service.EntityService;

@RestController
@RequestMapping("/api/entities")
public class EntityController {
	
	@Autowired
	EntityService entityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Entity>> getEntities() {
		
		List<Entity> entities = entityService.getEntities();
		return new ResponseEntity<List<Entity>>(entities, HttpStatus.OK);
	}
}
