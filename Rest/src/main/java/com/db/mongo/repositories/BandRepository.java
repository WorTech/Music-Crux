package com.db.mongo.repositories;

import com.db.mongo.models.Band;
import org.springframework.data.domain.Pageable;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface BandRepository extends MongoRepository<Band, String> {
	
	public List<Band> findByNameContaining(String name, Pageable pageable);
}