package repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import models.Album;


public interface AlbumRepository extends MongoRepository<Album, String>{

}
