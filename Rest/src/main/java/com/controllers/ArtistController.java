package com.controllers;

import com.services.ArtistService;
import com.db.mongo.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public common.models.Artist getArtist(@PathVariable("id") String id) {
        return artistService.getArtist(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name", "limit"})
    public Collection<common.models.Artist> getArtistsByName(@RequestParam("name") String name, @RequestParam("limit") int limit) {
        return artistService.getArtistsByName(name, limit);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Artist add(@RequestBody Artist artist) {
        System.out.println(artist);
        return artistService.add(artist);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Artist update(@PathVariable("id") String id, @RequestBody common.models.Artist artist) {
        return artistService.update(id, artist);
    }
}
