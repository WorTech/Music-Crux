package application.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.api.models.Molecule;
import application.api.repositories.DummyMoleculesRepository;

@Service
public class MoleculeService {
	
	@Autowired
	private DummyMoleculesRepository moleculesDao; // This is our DAO (Data access object)
	
	public Molecule getMolecule() {
		return moleculesDao.getMolecule();
	}
}
