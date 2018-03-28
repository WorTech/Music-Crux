package com.services;

import com.db.mongo.models.Artist;
import com.db.mongo.repositories.ArtistRepository;
import com.util.ArtistBusinessModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    /**
     * Returns an artist with the specified id.
     * @implNote Calls the Model converter to convert the db model into our business model
     * @param id id of the Artist
     * @return The Artist matching the id
     */
    public common.models.Artist getArtist(String id) {
        common.models.Artist artist = ArtistBusinessModelConverter
                .convertToBusinessModel(artistRepository.findOne(id));
        return artist;
    }

    /**
     * @param name  Search string
     * @param limit max number of artists to return
     * @implNote Calls the Model converter to convert the db model into our business model
     * @return artists matching the @name
     */
    public List<common.models.Artist> getArtistsByName(String name, int limit) {
        List<Artist> dbArtist = artistRepository.
                findByNameContaining(name, new PageRequest(0, limit));
        List<common.models.Artist> businessArtist = new ArrayList<>();
        for(Artist artist: dbArtist){
            businessArtist.add(ArtistBusinessModelConverter.convertToBusinessModel(artist));
        }
        return businessArtist;
    }

    /**This is the the internal add artist, not for use for users
     * @param artist Mongo model for Artist to add in the database
     *               db Model -> db Model
     * @return The Artist that was added
     */
    public Artist add(Artist artist) {

        return artistRepository.save(artist);
    }

    /**This is the add artist function for users to use
     * @param artist Business model for Artist to add in the database
     *               Business Model -> db Model
     * @return The Artist that was added
     */
    public Artist add(common.models.Artist artist) {
        Artist artistDBModel = ArtistBusinessModelConverter.convertFromBusinessModel(artist);
        return artistRepository.save(artistDBModel);
    }

    /**
     * @param id id of the Artist
     * @implNote User is only given the business model to interact with, not the db model
     * @return The Artist that was updated
     */
    public Artist update(String id, common.models.Artist artistUpdates) {
        //User gets the whole entity, modifies that entity, and sends the whole entity back
        common.models.Artist artist = this.getArtist(id);
        artist = artistUpdates;
        return artistRepository.save(ArtistBusinessModelConverter.convertFromBusinessModel(artist));
    }
}
