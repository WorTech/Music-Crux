package com.services;

import com.db.mongo.models.Artist;
import com.db.mongo.models.Band;
import com.db.mongo.models.Relationship;
import com.db.mongo.models.RelationshipType;
import com.db.mongo.repositories.ArtistRepository;
import com.db.mongo.repositories.BandRepository;
import com.db.mongo.repositories.RelationshipRepository;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    BandRepository bandRepository;

    @Autowired
    RelationshipRepository relationshipRepository;
    /**
     * @param id id of the Band
     * @return The Band matching the id
     */
    public Band getBand(String id) {return bandRepository.findOne(id);
    }

    /**
     * @param name  Search string
     * @param limit max number of bands to return
     * @return bands matching the @name
     */
    public List<Band> getBandsByName(String name, int limit) {
        return bandRepository.findByNameContaining(name, new PageRequest(0, limit));
    }

    /**
     * @param band Band to add in the database
     * @return The Band that was added
     */
    public Band add(Band band) {
        //1. Use the band.members.id array to query artist's document
        //2. Add their reference to a List<Artist> ids
        for (int i = 0; i < band.members.id.size(); i++){
            //System.out.println(band.members.id.get(i));
            //Artist foundArtist = artistRepository.findById(band.members.id.get(i).toString());
            //band.artists.add(foundArtist);

            //Create a new relationship.
            Relationship relationship = new Relationship();
            relationship.setType(RelationshipType.MEMBERSHIP);
            relationship.setEntityA(artistRepository.findById(band.members.id.get(i).toString()));
            relationship.setEntityB(band);
            relationshipRepository.save(relationship);
        }
        //Artist artist = artistRepository.findById(band.members[i])

        return bandRepository.save(band);
    }

    /**
     * @param id id of the Band
     * @return The Band that was updated
     */
    public Band update(String id, Band bandUpdates) {
        Band band = this.getBand(id);
        band = bandUpdates;
        return bandRepository.save(band);
    }
}
