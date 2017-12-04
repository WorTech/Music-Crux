package application.musiccruxDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.musiccruxDB.models.band.Band;

public interface BandRepository extends MongoRepository<Band, String> {

}
