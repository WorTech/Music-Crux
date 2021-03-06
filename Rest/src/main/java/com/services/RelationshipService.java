package com.services;

import com.db.mongo.models.Artist;
import com.db.mongo.models.Relationship;
import com.db.mongo.models.RelationshipType;
import com.db.mongo.repositories.ArtistRepository;
import com.db.mongo.repositories.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipService {

    @Autowired
    RelationshipRepository relationshipRepository;
    @Autowired
    ArtistRepository artistRepository;

    /**
     * @param id id of the relationship
     * @return The Relationship matching the id
     */
    public Relationship getRelationship(String id) {
        return relationshipRepository.findOne(id);
    }

    /**
     *
     * @param id : id of the entity
     * @return   : list of all relationships that entity is involved in
     */
    public List<Relationship> getEntityRelationships(String id){
        System.out.println("Returning again");
        return relationshipRepository.findByEntity(id);
    }
    /**
     * @param types
     * @param limit max number of relationships to return
     * @return labels matching the @types
     */
    public List<Relationship> getRelationshipsByTypes(List<String> types, int limit) {
        //TODO
        return null;
    }

    /**
     * @param relationship Relationship to add in the database
     * @return The Relationship that was added
     */
    public Relationship add(Relationship relationship) {
        return relationshipRepository.save(relationship);
    }

    /**
     * @param id
     * @return The Relationship that was updated
     */
    public Relationship update(String id, Relationship relationshipUpdates) {
        Relationship relationship = this.getRelationship(id);
        relationship = relationshipUpdates;
        return relationshipRepository.save(relationship);
    }
}
