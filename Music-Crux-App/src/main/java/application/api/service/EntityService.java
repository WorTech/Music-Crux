package application.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.api.models.db.Entity;
import application.api.repositories.DummyEntityRepository;

@Service
public class EntityService{

	@Autowired
	private DummyEntityRepository dummyEntityRepository; // This is our DAO (Data access object)

	public List<Entity> getEntities() {
		return dummyEntityRepository.getEntities();
	}
}
