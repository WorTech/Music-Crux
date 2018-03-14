package com.controllers;

import com.models.EntityType;
import com.models.Molecule;
import com.services.MoleculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MoleculeController {

    @Autowired
    private MoleculeService moleculeService;

    @RequestMapping(value = "/molecule", method = RequestMethod.GET)
    public ResponseEntity<Molecule> getMolecule(@RequestParam("focus") String entityId, @RequestParam("type") EntityType entityType, @RequestParam("depth") int depth){
        Molecule molecule = moleculeService.createMolecule(entityId, entityType, depth);
        return new ResponseEntity<Molecule>(molecule, HttpStatus.OK);
    }
}
