package application.discogsDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import application.discogsDB.models.Release;

public interface DiscogsReleaseRepository extends MongoRepository<Release, String> {

	
}
