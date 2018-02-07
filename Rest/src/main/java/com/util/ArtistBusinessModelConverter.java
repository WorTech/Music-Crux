package com.util;

import com.db.mongo.models.Artist;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ArtistBusinessModelConverter {

    public Artist convertFromBusinessModel(common.models.Artist businessArtist) {
        if (businessArtist == null) {
            return null;
        }

        Artist artist = new Artist();
        artist.setName(businessArtist.getName());

        return artist;
    }

    public common.models.Artist convertToBusinessModel(Artist artist) {
        if (artist == null) {
            return null;
        }

        common.models.Artist businessArtist = new common.models.Artist();
        businessArtist.setName(artist.getName());

        return businessArtist;
    }
}
