package com.musiccrux.discogs_xml_consumption.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.musiccrux.discogs_xml_consumption.models.Artist;
import com.musiccrux.discogs_xml_consumption.models.Label;

public interface LabelRepository extends MongoRepository<Label,String>{
	public Label findByName(String name);
}