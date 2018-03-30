package com.controllers;

import com.db.mongo.models.Album;
import com.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is the controller for the REST layer, all communication to and from Music-Crux is facilitated though
 * These REST commands. Each controller calls its respective service to deal with the business logic
 * Necessary
 */
@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    /**
     * @param id : An album with a unique id number is requested
     * @implNote : Calls album service
     * @return Album with specific id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Album getAlbum(@PathVariable("id") String id) {

        return albumService.getAlbum(id);
    }

    /**
     *
     * @param name: name of the album
     * @param limit: limit is the number of albums with names that match the search criteria to display
     * @implNote : Calls album service
     * @return A list of albums with the name
     */
    @RequestMapping(method = RequestMethod.GET, params = {"name", "limit"})
    public List<Album> getAlbumsByName(@RequestParam("name") String name, @RequestParam("limit") int limit) {

        return albumService.getAlbumsByName(name, limit);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"genres", "limit"})
    public List<Album> getAlbumsByGenres(@RequestParam("genres") List<String> genres, @RequestParam("limit") int limit) {

        return albumService.getAlbumsByGenres(genres, limit);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Album add(@RequestBody Album album) {

        return albumService.add(album);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Album update(@PathVariable("id") String id, @RequestBody Album album) {

        return albumService.update(id, album);
    }


}
