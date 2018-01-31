package com.Controllers;

import com.Services.ArtistService;
import com.db.mongo.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Artist getArtist(@PathVariable("id") String id) {
        return artistService.getArtist(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name", "limit"})
    public Collection<Artist> getArtistsByName(@RequestParam("name") String name, @RequestParam("limit") int limit) {
        return artistService.getArtistsByName(name, limit);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Artist add(@RequestBody Artist artist) {
        return artistService.add(artist);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Artist update(@PathVariable("id") String id, @RequestBody Artist artist) {

        return artistService.update(id, artist);
    }

}
