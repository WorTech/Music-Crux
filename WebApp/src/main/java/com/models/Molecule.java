package com.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.common.collect.Lists;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class Molecule {
    private List<Entity> entities = new ArrayList<Entity>();
    private List<Relationship> relationships = new ArrayList<Relationship>();

    public Molecule(List<Entity> entities, List<Relationship> relationships) {
        this.entities = entities;
        this.relationships = relationships;
    }

    public Molecule() {
        //relationships = Lists.newArrayList(new Relationship)
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    /**
     * This method checks whether the focus is an artist or band.
     * @param
     * @return
     */
    //Artists will always be EntityA in the Relationship
    //Bands will always be EntityB in the Relationship
    public Boolean checkType(){
        return true;
    }

    public void addEntitiesFromRelationships(EntityType entityType) {
        if (entityType == EntityType.ARTIST) {
            int i = 0;
            while (i < this.relationships.size()) {
                //for (int i = 0; i < this.relationships.size(); i++){
                //EntityA is the searched document (doesn't change)
                //EntityB is the related document (changes)
                entities.add(this.relationships.get(i).getEntityB());
                i++;
            }
            //Add the focus itself to the list of entities.
            if (this.relationships.size() > 0)
                entities.add(this.relationships.get(i - 1).getEntityA());
        }
        if (entityType == EntityType.BAND) {
            int i = 0;
            while(i < this.relationships.size()) {
                //EntityA is going to be a member of the band.
                entities.add(this.relationships.get(i).getEntityA());
                i++;
            }
            if(this.relationships.size() > 0){
                entities.add(this.relationships.get(i-1).getEntityB());
            }
        }
    }
    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }

    public void addEntities(List<Entity> entities) {
        this.entities.addAll(entities);
    }

    public void addRelationships(List<Relationship> relationships) {
        this.relationships.addAll(relationships);
    }

    public static Molecule join(Molecule molA, Molecule molB) {

        List<Entity> joinedEntities = new ArrayList<>();
        joinedEntities.addAll(molA.getEntities());
        joinedEntities.addAll(molB.getEntities());

        List<Relationship> joinedRelationships = new ArrayList<>();
        joinedRelationships.addAll(molA.getRelationships());
        joinedRelationships.addAll(molB.getRelationships());

        return new Molecule(joinedEntities, joinedRelationships);
    }

    public static Molecule join(List<Molecule> molecules) {

        List<Entity> joinedEntities = new ArrayList<>();
        List<Relationship> joinedRelationships = new ArrayList<>();

        for (Molecule molecule : molecules) {
            joinedEntities.addAll(molecule.getEntities());
            joinedRelationships.addAll(molecule.getRelationships());
        }
        return new Molecule(joinedEntities, joinedRelationships);
    }

}
