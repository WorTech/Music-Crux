package com.util;

import com.db.mongo.models.RelationshipType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RelationshipTypeBusinessModelConverter {

    public common.models.RelationshipType convertToBusinessModel(RelationshipType relationshipType) {
        switch (relationshipType) {
            case MEMBERSHIP:
                    return common.models.RelationshipType.MEMBERSHIP;
            default:
                return common.models.RelationshipType.UNKNOWN;
        }
    }

    public RelationshipType convertFromBusinessModel(common.models.RelationshipType businessRelationshipType) {
        switch (businessRelationshipType) {
            case MEMBERSHIP:
                return RelationshipType.MEMBERSHIP;
            default:
                return RelationshipType.UNKNOWN;
        }
    }
}
