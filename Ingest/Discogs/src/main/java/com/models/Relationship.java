package com.models;

import lombok.Data;

@Data
public class Relationship {
    private Entity entityA, entityB;
    private RelationshipType type;
}
