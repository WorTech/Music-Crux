package com.util;

import com.db.mongo.models.Artist;
import lombok.experimental.UtilityClass;
/**
 * Utility class to convert between the business model and the DB model
 */
@UtilityClass
public class ArtistBusinessModelConverter {
    /**
     * @param businessArtist: Inputs the business model
     * @implNote : Checks for null entity, then converts the entity to the Db model
     * @return artist entity in DB model
     */
    public Artist convertFromBusinessModel(common.models.Artist businessArtist) {
        if (businessArtist == null) {
            return null;
        }
        Artist artist = new Artist();
        artist.setId(businessArtist.getId());
        artist.setName(businessArtist.getName());
        return artist;
    }
    /**
     * @param artist: Inputs the business model
     * @implNote : Checks for null entity, then converts the entity to the Db model
     * @return artist entity in DB model
     */
    public common.models.Artist convertToBusinessModel(Artist artist) {
        if (artist == null) {
            return null;
        }
        common.models.Artist businessArtist = new common.models.Artist();
        businessArtist.setId(artist.getId());
        businessArtist.setName(artist.getName());
        return businessArtist;
    }
}
