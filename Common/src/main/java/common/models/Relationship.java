package common.models;

import lombok.Data;

@Data
public class Relationship {
    private RelationshipType type;

    private Entity entityA, entityB;
}