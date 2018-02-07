package common.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Relationship {
    private RelationshipType type;

    private Entity entityA, entityB;
}