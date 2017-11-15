package application.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
