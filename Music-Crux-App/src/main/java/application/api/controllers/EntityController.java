package application.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.api.models.Molecule;
import application.api.models.db.Entity;
import application.api.service.EntityService;

@RestController
@RequestMapping("/api")
public class EntityController {

	@Autowired
	EntityService entityService;

	@RequestMapping(value = "/entity/{depth}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Molecule> createMoleculeFromEntity(@RequestBody Entity entity,
			@PathVariable("depth") Integer depth) {

		Molecule molecule = entityService.createMoleculeFromEntity(entity, depth);
		HttpStatus status = molecule == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return new ResponseEntity<Molecule>(molecule, status);
	}

	@RequestMapping(value = "/entities/{depth}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Molecule> createMoleculeFromEntities(@RequestBody List<Entity> entities,
			@PathVariable("depth") Integer depth) {

		Molecule molecule = entityService.createMoleculeFromEntities(entities, depth);
		HttpStatus status = molecule == null ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return new ResponseEntity<Molecule>(molecule, status);
	}
}
