package com.util;

import com.db.mongo.models.RelationshipType;
import lombok.experimental.UtilityClass;
/**
 * Utility class to convert between the business model and the DB model
 */
@UtilityClass
public class RelationshipTypeBusinessModelConverter {
    /**
     * @param relationshipType: Inputs the business model
     * @implNote : Checks for null entity, then converts the entity to the Db model
     * @return relationshipType entity in DB model
     */
    public common.models.RelationshipType convertToBusinessModel(RelationshipType relationshipType) {
        switch (relationshipType) {
            case MEMBERSHIP:
                    return common.models.RelationshipType.MEMBERSHIP;
            default:
                return common.models.RelationshipType.UNKNOWN;
        }
    }

    /**
     * @param businessRelationshipType: Inputs the business model
     * @implNote : Checks for null entity, then converts the entity to the Db model
     * @return relationshipType entity in DB model
     */
    public RelationshipType convertFromBusinessModel(common.models.RelationshipType businessRelationshipType) {
        switch (businessRelationshipType) {
            case MEMBERSHIP:
                return RelationshipType.MEMBERSHIP;
            default:
                return RelationshipType.UNKNOWN;
        }
    }
}
