package com.musiccrux.discogs_xml_consumption.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.musiccrux.discogs_xml_consumption.models.Location;

public interface CityRepository extends CrudRepository<Location, Integer>{
	@Query(value="SELECT * FROM CITY WHERE Name like %?1%", nativeQuery=true)
	Location findByName(String name);
}
