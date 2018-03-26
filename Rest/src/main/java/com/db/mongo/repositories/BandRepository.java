package com.db.mongo.repositories;

import com.db.mongo.models.Band;
import org.springframework.data.domain.Pageable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface BandRepository extends MongoRepository<Band, String> {

	@Query(value = "{'name': {$regex : ?0, $options: 'i'}}")
	public List<Band> findByNameContaining(String name, Pageable pageable);
}