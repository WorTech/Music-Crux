package application.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.api.models.ui.MoleculeUI;
import application.api.service.MoleculeService;

@RestController
@RequestMapping("/api")
public class MoleculeController {
	
	@Autowired
	private MoleculeService moleculeService;
	
	@RequestMapping(value = "/molecule", method = RequestMethod.GET)
	public ResponseEntity<MoleculeUI> getMolecules(@RequestParam("focus") String entityId, @RequestParam("depth") int depth ) {
		
		MoleculeUI molecule = moleculeService.createMoleculeFor(entityId, depth);
		
		return new ResponseEntity<MoleculeUI>(molecule, HttpStatus.OK);
	}
}
