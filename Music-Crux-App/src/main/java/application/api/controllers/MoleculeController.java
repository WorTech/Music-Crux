package application.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.api.models.Molecule;
//import application.api.service.MoleculeService;

@RestController
@RequestMapping("/api/molecules")
public class MoleculeController {
	
//	@Autowired
//	private MoleculeService moleculeService;
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<Molecule> getMolecules() {
//		
//		Molecule molecule = moleculeService.getMolecule();
//		return new ResponseEntity<Molecule>(molecule, HttpStatus.OK);
//	}
}
