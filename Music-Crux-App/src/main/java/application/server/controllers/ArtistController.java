package application.server.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import application.dummies.Entity;
import application.dummies.EntityType;
import application.dummies.Member;
import application.dummies.Molecule;
import application.dummies.Relationship;
import application.dummies.RelationshipType;

@Controller
@RestController
@RequestMapping("/api")
public class ArtistController {
	@RequestMapping(value = "/molecules", method=RequestMethod.GET)
	public ResponseEntity<Molecule> getMolecules(){
		List<Entity> entities = new ArrayList<Entity>();
		List<Relationship> relationships = new ArrayList<Relationship>();
		
		Entity entity1 = new Entity(123, EntityType.ARTIST, "ARTIST NUMBER 1");
		Entity entity2 = new Entity(456, EntityType.BAND, "BAND NUMBER 1");
		Entity entity3 = new Entity(789, EntityType.ARTIST, "ARTIST NUMBER 2");
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		
		Relationship r1 = new Relationship(RelationshipType.FEATURED, 123, 456);
		Relationship r2 = new Relationship(RelationshipType.MEMBER, 456, 123);
		Relationship r3 = new Relationship(RelationshipType.FEATURED, 789,123);
		relationships.add(r1);
		relationships.add(r2);
		relationships.add(r3);
		
		Molecule molecule = new Molecule(entities, relationships);
		return new ResponseEntity<Molecule>(molecule, HttpStatus.OK);
	}
	@RequestMapping(value = "/entities", method=RequestMethod.GET)
	public ResponseEntity getEntities() {
		List<Entity> entities = new ArrayList<Entity>();
		//Entity(String id, EntityType type, String label)
		Entity entity1 = new Entity(123, EntityType.ARTIST, "ARTIST NUMBER 1");
		Entity entity2 = new Entity(456, EntityType.BAND, "BAND NUMBER 1");
		Entity entity3 = new Entity(789, EntityType.ARTIST, "ARTIST NUMBER 2");
		entities.add(entity1);
		entities.add(entity2);
		entities.add(entity3);
		return new ResponseEntity<List<Entity>>(entities, HttpStatus.OK);
	}
}
