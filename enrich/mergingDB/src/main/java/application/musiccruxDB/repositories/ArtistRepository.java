package application.musiccruxDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.musiccruxDB.models.artist.Artist;

public interface ArtistRepository extends MongoRepository<Artist, String>{

	 
}
