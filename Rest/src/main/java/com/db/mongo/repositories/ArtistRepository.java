package com.db.mongo.repositories;

import com.db.mongo.models.Artist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface ArtistRepository extends MongoRepository<Artist, String> {

	public Artist findById(String id);
	@Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
	public List<Artist> findByNameContaining(String name, Pageable pageable);
}
