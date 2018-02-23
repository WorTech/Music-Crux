package com.controllers;

import com.db.mongo.models.Album;
import com.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Album getAlbum(@PathVariable("id") String id) {

        return albumService.getAlbum(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name", "limit"})
    public List<Album> getAlbumsByName(@RequestParam("name") String name, @RequestParam("limit") int limit) {

        return albumService.getAlbumsByName(name, limit);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"genres", "limit"})
    public List<Album> getAlbumsByGenres(@RequestParam("genres") List<String> genres, @RequestParam("limit") int limit) {

        return albumService.getAlbumsByGenres(genres, limit);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Album addAlbum(@RequestBody Album album) {
        return albumService.add(album);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Album update(@PathVariable("id") String id, @RequestBody Album album) {

        return albumService.update(id, album);
    }


}
