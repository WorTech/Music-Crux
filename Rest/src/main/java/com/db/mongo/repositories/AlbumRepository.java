package com.db.mongo.repositories;

import com.db.mongo.models.Album;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Repository to create queries to interact with a specific collection
 */
@CrossOrigin
public interface AlbumRepository extends MongoRepository<Album, String>{
    //allows the queries to be in upper and lower case
    @Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
    public List<Album> findByNameContaining(String name, Pageable pageable);
    public List<Album> findByGenresContaining(List<String> genres, Pageable pageable);
    public List<Album> findByCountry(String countries);
}
