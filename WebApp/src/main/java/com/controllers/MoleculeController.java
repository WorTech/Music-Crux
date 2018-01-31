package com.controllers;

import com.models.Molecule;
import com.services.MoleculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MoleculeController {

    @Autowired
    private MoleculeService moleculeService;

    @RequestMapping(value = "/molecule", method = RequestMethod.GET)
    public ResponseEntity<Molecule> getMolecule(@RequestParam("focus") String entityId, @RequestParam("depth") int depth){
        Molecule molecule = moleculeService.createMolecule(entityId, depth);
        return new ResponseEntity<Molecule>(molecule, HttpStatus.OK);
    }
}
