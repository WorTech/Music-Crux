package com.db.mongo.repositories;

import com.db.mongo.models.Album;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface AlbumRepository extends MongoRepository<Album, String>{

    public List<Album> findByNameContaining(String name, Pageable pageable);
    public List<Album> findByGenresContaining(List<String> genres, Pageable pageable);
    public List<Album> findByCountry(String countries);
}
