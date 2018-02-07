package com.util;

import com.db.mongo.models.Band;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BandBusinessModelConverter {

    public Band convertFromBusinessModel(common.models.Band businessBand) {
        if (businessBand == null) {
            return null;
        }

        Band band = new Band();
        band.setName(businessBand.getName());

        return band;
    }

    public common.models.Band convertToBusinessModel(Band band) {
        if (band == null) {
            return null;
        }

        common.models.Band businessBand = new common.models.Band();
        businessBand.setName(band.getName());

        return businessBand;
    }
}
