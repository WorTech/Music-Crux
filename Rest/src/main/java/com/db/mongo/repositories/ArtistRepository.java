package com.db.mongo.repositories;

import com.db.mongo.models.Artist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ArtistRepository extends MongoRepository<Artist, String> {
	
	public List<Artist> findByNameContaining(String name, Pageable pageable);
}
