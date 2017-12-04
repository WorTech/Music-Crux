package application.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import application.musiccruxDB.models.band.Band;
import application.musiccruxDB.models.entity.Entity;
import application.musiccruxDB.models.entity.EntityType;
import application.musiccruxDB.repositories.BandRepository;
import application.musiccruxDB.repositories.EntityRepository;

/**
 * Uses the Entity Repository and generates a Band of the entities of type Band
 *
 */
@Component
@Order(value = 2)
public class GenerateBandModels implements CommandLineRunner {

	@Autowired
	private EntityRepository entityRepository;

	@Autowired
	private BandRepository db;

	/**
	 * Creates an band from each of the Entities in the Musiccrux database
	 * 
	 * @return void
	 */
	private void constructBandFromEntity() {
		for (Entity entity : entityRepository.findByType(EntityType.BAND)) {
			//Band band = new Band(entity.getId(), entity.getLabel());
			Band band = new Band();
			band.setEntity(entity);
			band.setLabel(entity.getLabel());
			db.save(band);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		constructBandFromEntity();
	}

}
