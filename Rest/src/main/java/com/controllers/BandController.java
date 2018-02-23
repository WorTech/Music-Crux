package com.controllers;

import com.db.mongo.models.Band;
import com.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/band")
public class BandController {

    @Autowired
    BandService bandService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Band getBand(@PathVariable("id") String id) {

        return bandService.getBand(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name", "limit"})
    public Collection<Band> getBandsByName(@RequestParam("name") String name, @RequestParam("limit") int limit) {

        return bandService.getBandsByName(name, limit);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Band add(@RequestBody Band band) {

        //System.out.println(band.getMembers().toString());
        //Band newBand = new ObjectMapper().readValue(band, Band.class);
        return bandService.add(band);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Band update(@PathVariable("id") String id, @RequestBody Band band) {

        return bandService.update(id, band);
    }

}
