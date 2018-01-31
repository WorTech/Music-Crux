package com.db.mongo.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Entity {
    @Id
    private String id;
    private EntityType type;
    @Indexed
    private String name; // artist name, band name, etc

    Entity(EntityType entityType) {
        this.setType(entityType);
    }
}
