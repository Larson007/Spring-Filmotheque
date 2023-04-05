package fr.mbadev.filmotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mbadev.filmotheque.bo.Genre;
import fr.mbadev.filmotheque.dao.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public List<Genre> listeGenre() {
		return genreRepository.findAll();
	}

	@Override
	public void saveGenre(Genre genre) throws Exception {
		genreRepository.save(genre);

	}

	@Override
	public void deleteGenre(int id) {
		genreRepository.deleteById(id);

	}

}
