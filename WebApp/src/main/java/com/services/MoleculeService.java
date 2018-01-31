package com.services;

import com.models.Entity;
import com.models.Relationship;
import com.models.Molecule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MoleculeService {
//
//    @Autowired
//    EntityRepository entityRepository;
//
//    @Autowired
//    RelationshipRepository relationshipRepository;

    private RestTemplate restTemplate = new RestTemplate();
    /**
     * Returns a molecule for the specified @entityId .
     *
    // * @param entityId : id of the current entity being searched
    // * @param depth    : The depth to search
     * @return : MoleculeUI
     */
    public Molecule createMolecule(String entityId, int depth){
       return null;
    }
//    public Molecule createMoleculeFor(String entityId, int depth) {
//
//        HashSet<String> visited = new HashSet<>();
//        Molecule molecule = new Molecule();
//
//        if (depth <= 0) {
//            //Entity entity = entityRepository.findOne(entityId); /* REPLACED WITH HTTP REQUEST */
//            Entity entity = restTemplate.getForObject("https://localhost:8080/MusicCrux/api/{type}/{id}", Entity.class);
//            molecule.addEntity(entity);
//        } else {
//            populateMolecule(entityId, depth, visited, molecule);
//        }
//        return (molecule);
//    }
//
//    /**
//     * Recursively searches the @entityId for a depth of @depth > 1. The resulting entities and
//     * relationships are appended to the provided molecule.
//     *
//     * @param entityId : id of the current entity being searched
//     * @param depth    : The depth of the search
//     * @param visited  : hashed ids of the visited entities
//     * @param molecule : The molecule being modified
//     */
//    private void populateMolecule(String entityId, int depth, HashSet<String> visited, Molecule molecule) {
//
//        if (depth <= 0 || visited.contains(entityId)) {
//            return;
//        }
//
//        depth -= 1;
//
//        //Entity entity = entityRepository.findOne(entityId); /* REPLACED WITH HTTP REQUEST */
//        Entity entity = restTemplate.getForObject("https://localhost:8080/MusicCrux/api/{type}/{id}", Entity.class);
//        //List<Relationship> relationships = relationshipRepository.findByEntity(entityId); /* REPLACED WITH HTTP REQUEST */
//        List<Relationship> relationships = restTemplate.getForObject("https://localhost:8080/MusicCrux/api/Relationship/{id}", Relationship.class);
//
//        molecule.addEntity(entity);
//        molecule.addRelationships(relationships);
//        visited.add(entityId);
//
//        for (Relationship relationship : relationships) {
//
//            if (!visited.contains(relationship.getEntityA().getId())) {
//                if (depth == 0) { // Once the end has been reached, the connected entity should be added to the
//                    // molecule but it shouldn't recursively.
//                    molecule.addEntity(relationship.getEntityA());
//                    visited.add(relationship.getEntityA().getId());
//                } else {
//                    populateMolecule(relationship.getEntityA().getId(), depth, visited, molecule);
//                }
//            }
//            if (!visited.contains(relationship.getEntityB().getId())) {
//                if (depth == 0) {
//                    molecule.addEntity(relationship.getEntityB());
//                    visited.add(relationship.getEntityB().getId());
//                } else {
//                    populateMolecule(relationship.getEntityB().getId(), depth, visited, molecule);
//                }
//            }
//        }
//    }

}