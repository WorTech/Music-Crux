package com.Services;

import com.db.mongo.models.Band;
import com.db.mongo.repositories.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {


    @Autowired
    BandRepository bandRepository;

    /**
     * @param id id of the Band
     * @return The Band matching the id
     */
    public Band getBand(String id) {
        return bandRepository.findOne(id);
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
