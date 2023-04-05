package fr.mbadev.filmotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mbadev.filmotheque.bo.Film;
import fr.mbadev.filmotheque.dao.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	@Override
	public void saveFilm(Film film) throws Exception {
		valider(film);
		filmRepository.save(film);
	}

	@Override
	public List<Film> listeFilm() {
		return filmRepository.findAll();
	}

	@Override
	public void deleteFilm(int id) {
		filmRepository.deleteById(id);
		
	}
	
	private void valider(Film film) throws Exception {
		if (film.getTitre() == null || film.getTitre().isBlank()) {
			throw new Exception("Le titre doit être renseignée");
		}
	}

	@Override
	public Film filmById(int id) {
		return filmRepository.findById(id).get();
	}
}
