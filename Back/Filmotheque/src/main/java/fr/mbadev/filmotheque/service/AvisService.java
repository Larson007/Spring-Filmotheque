package fr.mbadev.filmotheque.service;

import java.util.List;

import fr.mbadev.filmotheque.bo.Avis;

public interface AvisService {

	public List<Avis> listeAvis();
	void saveAvis(Avis avis) throws Exception;
	public void deleteAvis(int id);
}
