package com.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Entity;
import com.models.Relationship;
import com.models.Molecule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MoleculeService {
//
//    @Autowired
//    EntityRepository entityRepository;
//
//    @Autowired
//    RelationshipRepository relationshipRepository;

    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper mapper = new ObjectMapper();
    /**
     *
     * @param entityId : id of the current entity being searched
     * @return         : list of relationships and entities related to the searched entity
     */
    public Molecule createMolecule(String entityId){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        String URL = "http://localhost:8081/relationship";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL)
                .queryParam("id", entityId);

        //HttpEntity<?> entity = new HttpEntity<>(headers);
        //ParameterizedTypeReference<List<Relationship>> listOfRelationships = new ParameterizedTypeReference<List<Relationship>>() {};

        Molecule molecule = new Molecule();
        System.out.println("1");
        ResponseEntity<List<Relationship>> responseList = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Relationship>>() {});
        List<Relationship> list_relationships = responseList.getBody();
        System.out.println(list_relationships);

        molecule.setRelationships(list_relationships);
        //System.out.println(molecule.getRelationships().get(0).getEntityB());
        molecule.addEntitiesFromRelationships();
        return molecule;
    }

    /**
     * Returns a molecule for the specified @entityId .
     *
    // * @param entityId : id of the current entity being searched
    // * @param depth    : The depth to search
     * @return : MoleculeUI
     */
//    public Molecule createMolecule(String entityId, int depth){
//        return null;
//    }
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