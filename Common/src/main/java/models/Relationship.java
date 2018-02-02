package models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Relationship {
    private RelationshipType type;

    private Entity entityA, entityB;
}