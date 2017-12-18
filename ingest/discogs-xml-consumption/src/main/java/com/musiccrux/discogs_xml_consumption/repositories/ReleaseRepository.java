package com.musiccrux.discogs_xml_consumption.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.musiccrux.discogs_xml_consumption.models.Release;

public interface ReleaseRepository extends MongoRepository<Release, String>{

}
