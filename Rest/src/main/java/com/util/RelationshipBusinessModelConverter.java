package com.util;

import com.db.mongo.models.Entity;
import com.db.mongo.models.Relationship;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RelationshipBusinessModelConverter {

    public Relationship convertFromBusinessModel(common.models.Relationship businessRelationship) {
        if (businessRelationship == null) {
            return null;
        }
        Entity entityA = EntityBusinessModelConverter.convertFromBusinessModel(businessRelationship.getEntityA());
        Entity entityB = EntityBusinessModelConverter.convertFromBusinessModel(businessRelationship.getEntityB());

        Relationship relationship = new Relationship();
        relationship.setEntityA(entityA);
        relationship.setEntityB(entityB);
        relationship.setType(RelationshipTypeBusinessModelConverter
                .convertFromBusinessModel(businessRelationship.getType()));

        return relationship;
    }

    public common.models.Relationship convertToBusinessModel(Relationship relationship) {

        if (relationship == null) {
            return null;
        }

        common.models.Entity entityA = EntityBusinessModelConverter.convertToBusinessModel(relationship.getEntityA());
        common.models.Entity entityB = EntityBusinessModelConverter.convertToBusinessModel(relationship.getEntityB());

        common.models.Relationship businessRelationship = new common.models.Relationship();
        businessRelationship.setEntityA(entityA);
        businessRelationship.setEntityB(entityB);
        businessRelationship.setType(RelationshipTypeBusinessModelConverter
                .convertToBusinessModel(relationship.getType()));

        return businessRelationship;
    }
}
