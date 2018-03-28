package com.util;

import com.db.mongo.models.Artist;
import com.db.mongo.models.Band;
import com.db.mongo.models.Entity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EntityBusinessModelConverter {

    public Entity convertFromBusinessModel(common.models.Entity businessEntity) {
        if (businessEntity == null) {
            return null;
        }
        return extractConcreteClassFromBusinessModel(businessEntity);
    }

    public common.models.Entity convertToBusinessModel(Entity entity) {
        if (entity == null) {
            return null;
        }
        return extractConcreteClassToBusinessModel(entity);
    }

    /**
     * Examines the @businessEntity to determine the interface implementation.
     * The converter for that concrete class is then used to create the actual model from the business model.
     *
     * @param businessEntity
     * @return
     */
    private Entity extractConcreteClassFromBusinessModel(common.models.Entity businessEntity) {

        switch (businessEntity.getType()) {
            case ARTIST: {
                return ArtistBusinessModelConverter.convertFromBusinessModel((common.models.Artist) businessEntity);
            }
            case BAND: {
                return BandBusinessModelConverter.convertFromBusinessModel((common.models.Band) businessEntity);
            }
        }
        return null;
    }

    /**
     * Examines the @entity to determine the interface implementation.
     * The converter for that concrete class is then used to create the business model from the actual model.
     *
     * @param entity
     * @return
     */
    private common.models.Entity extractConcreteClassToBusinessModel(Entity entity) {

        switch (entity.getType()) {
            case ARTIST: {
                return ArtistBusinessModelConverter.convertToBusinessModel((Artist) entity);
            }
            case BAND: {
                return BandBusinessModelConverter.convertToBusinessModel((Band) entity);
            }
        }
        return null;
    }
}
