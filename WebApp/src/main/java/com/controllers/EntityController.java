package com.controllers;

import com.models.Entity;
import com.models.EntityType;
import com.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EntityController {

	@Autowired
	EntityService entityService;

	@RequestMapping(value = "/entity", method = RequestMethod.GET)
	//January 17th, 2018 Added a request parameter in EntityController for type (as in EntityType).
	public ResponseEntity<List<Entity>> createMolecule(@RequestParam("type") String type,
													   @RequestParam("name") String name,
													   @RequestParam("limit") int limit){
		List<Entity> entities = entityService.getEntitySearchResults(type, name, limit);
		HttpStatus status = entities == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;

		return new ResponseEntity<List<Entity>>(entities, status);

//		List<EntityUI> entities = entityService.getEntitySearchResults(label, limit);
//		HttpStatus status = entities == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
//		return new ResponseEntity<List<EntityUI>>(entities, status);
//	}
	}
}
