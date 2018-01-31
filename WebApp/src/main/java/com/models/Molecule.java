package com.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Molecule {
    private List<Entity> entities = new ArrayList<>();
    private List<Relationship> relationships = new ArrayList<>();

    public Molecule(List<Entity> entities, List<Relationship> relationships) {
        this.entities = entities;
        this.relationships = relationships;
    }

    public Molecule() {
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
