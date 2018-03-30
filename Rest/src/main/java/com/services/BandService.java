package com.services;

import com.db.mongo.models.Artist;
import com.db.mongo.models.Band;
import com.db.mongo.models.Relationship;
import com.db.mongo.models.RelationshipType;
import com.db.mongo.repositories.ArtistRepository;
import com.db.mongo.repositories.BandRepository;
import com.db.mongo.repositories.RelationshipRepository;
import com.util.BandBusinessModelConverter;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public common.models.Band getBand(String id) {
        common.models.Band band = BandBusinessModelConverter.convertToBusinessModel(bandRepository.findOne(id));
        return band;
    }

    /**
     * @param name  Search string
     * @param limit max number of bands to return
     * @return bands matching the @name
     */
    public List<common.models.Band> getBandsByName(String name, int limit) {
        List<Band> dbBand = bandRepository.
                findByNameContaining(name, new PageRequest(0, limit));
        List<common.models.Band> businessBand = new ArrayList<>();
        for(Band band: dbBand){
            businessBand.add(BandBusinessModelConverter.convertToBusinessModel(band));
        }
        return businessBand;
    }

    /**This is the internal add band, not for use by users
     * @param band Band to add in the database
     * @return The Band that was added
     */
    public Band add(Band band) {
        //1. Use the band.members.id array to query artist's document
        //2. Add their reference to a List<Artist> ids
        for (int i = 0; i < band.members.id.size(); i++){
          if(artistRepository.findById(String.valueOf(band.members.name.indexOf(i))) == null) {
            Artist artist = artistRepository.findById(String.valueOf(band.members.name.indexOf(i)));
            artistRepository.save(artist);
          }
            //Create a new relationship.
            Relationship relationship = new Relationship();
            relationship.setType(RelationshipType.MEMBERSHIP);
            relationship.setEntityA(artistRepository.findById(band.members.id.get(i).toString()));
            relationship.setEntityB(band);
            relationshipRepository.save(relationship);
        }
        return bandRepository.save(band);
    }


    /**This is the external add band, for use by users
     * @param band Band to add in the database
     * @return The Band that was added
     */
    public Band add(common.models.Band band) {
        Band dbBand = new Band();
        //1. Use the band.members.id array to query artist's document
        //2. Add their reference to a List<Artist> ids
        for (int i = 0; i < band.members.id.size(); i++){
            BandBusinessModelConverter.convertFromBusinessModel(band);
            //Create a new relationship.
            Relationship relationship = new Relationship();
            relationship.setType(RelationshipType.MEMBERSHIP);
            relationship.setEntityA(artistRepository.findById(dbBand.members.id.get(i).toString()));
            relationship.setEntityB(dbBand);
            relationshipRepository.save(relationship);
        }
        return bandRepository.save(dbBand);
    }

    /**
     * @param id id of the Band
     * @return The Band that was updated
     */
    public Band update(String id, common.models.Band bandUpdates) {
        common.models.Band band = this.getBand(id);
        band = bandUpdates;
        return bandRepository.save(BandBusinessModelConverter.convertFromBusinessModel(band));
    }
}
