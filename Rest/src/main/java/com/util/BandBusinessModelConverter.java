package com.util;

import com.db.mongo.models.Band;
import lombok.experimental.UtilityClass;

/**
 * Utility class to convert between the business model and the DB model
 */
@UtilityClass
public class BandBusinessModelConverter {

    /**
     * @param businessBand: Inputs the business model
     * @implNote : Checks for null entity, then converts the entity to the Db model
     * @return band entity in DB model
     */
    public Band convertFromBusinessModel(common.models.Band businessBand) {
        if (businessBand == null) {
            return null;
        }
        Band band = new Band();
        band.setId(businessBand.getId());
        band.setName(businessBand.getName());
        if(!businessBand.getMembers().getName().isEmpty() && !businessBand.getMembers().getId().isEmpty()) {
            band.members = new Band.Members();
            band.members.setId(businessBand.members.getId());
            band.members.setName(businessBand.members.getName());
        }
        return band;
    }

    /**
     *
     * @param band: Inputs the DB model for Band
     * @implNote : Checks for null entity, then converts the entity to the Db model
     * @return businessBand in business model
     */
    public common.models.Band convertToBusinessModel(Band band) {
        if (band == null) {
            return null;
        }
        common.models.Band businessBand = new common.models.Band();
        businessBand.setId(band.getId());
        businessBand.setName(band.getName());
        if(!band.getMembers().getName().isEmpty() && !band.getMembers().getId().isEmpty()) {
            businessBand.members = new common.models.Band.Members();
            businessBand.members.setId(band.members.getId());
            businessBand.members.setName(band.members.getName());
        }
        return businessBand;
    }
}
