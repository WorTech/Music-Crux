package application.discogsDB.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import application.discogsDB.models.Artist;
public interface DiscogsArtistRepository extends MongoRepository<Artist, String> {
	
	public Artist findByName(String name);

	// Checks if an Artist has a members field.
	@Query("{ 'members' : {$exists:true} }")
	public List<Artist> findAllArtistsWithMembers();

}
