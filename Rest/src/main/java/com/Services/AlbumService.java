package com.Services;

import com.db.mongo.models.Album;
import com.db.mongo.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    /**
     * @param id id of the Album
     * @return The Album matching the id
     */
    public Album getAlbum(String id) {

        return albumRepository.findOne(id);
    }

    /**
     * @param name  Search string
     * @param limit max number of albums to return
     * @return Albums matching the @name
     */
    public List<Album> getAlbumsByName(String name, int limit) {
        return albumRepository.findByNameContaining(name, new PageRequest(0, limit));
    }

    /**
     * @param genres genres to search by
     * @param limit  max number of albums to return
     * @return albums matching the @genres
     */
    public List<Album> getAlbumsByGenres(List<String> genres, int limit) {

        return albumRepository.findByGenresContaining(genres, new PageRequest(0, limit));
    }

    /**
     * Adds a new album to the database
     *
     * @param album Album to add in the database
     * @return The Album that was added
     */
    public Album add(Album album) {
        return albumRepository.save(album);
    }

    /**
     * Updates an Album already in the database
     *
     * @param id id of the Album
     * @return The Album that was updated
     */
    public Album update(String id, Album albumUpdates) {
        Album album = this.getAlbum(id);
        album = albumUpdates;
        return albumRepository.save(album);
    }
}