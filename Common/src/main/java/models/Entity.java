package models;


import lombok.Data;

@Data
public class Entity {
    private EntityType type;
    private String name; // artist name, band name, etc

    Entity(EntityType entityType) {
        this.setType(entityType);
    }
}