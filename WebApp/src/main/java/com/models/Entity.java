package com.models;

import lombok.Data;

@Data
public class Entity {
    // feel free to change to int or long if that fits your model better
    private String id;

    private EntityType type;

    // artist name, band name, etc
    private String name;

    public Entity(EntityType entityType) {
        this.setType(entityType);
    }

}
