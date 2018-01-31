package com.db.mongo.repositories;

import com.db.mongo.models.Label;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LabelRepository extends MongoRepository<Label, String> {

    public List<Label> findByNameContaining(String name, Pageable pageable);
}
