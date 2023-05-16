package fr.mbadev.filmotheque.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mbadev.filmotheque.bo.Avis;
import fr.mbadev.filmotheque.dao.AvisRepository;
import fr.mbadev.filmotheque.service.AvisService;

@Service
public class AvisServiceImpl implements AvisService {

	@Autowired
	private AvisRepository avisRepository;
	
	@Override
	public List<Avis> listeAvis() {
		return avisRepository.findAll();
	}

	@Override
	public void saveAvis(Avis avis) throws Exception {
		avisRepository.save(avis);

	}

	@Override
	public void deleteAvis(int id) {
		avisRepository.deleteById(id);

	}

}
