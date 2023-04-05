package fr.mbadev.filmotheque.service;

import java.util.List;

import fr.mbadev.filmotheque.bo.Genre;

public interface GenreService {

	public List<Genre> listeGenre();
	void saveGenre(Genre genre) throws Exception;
	public void deleteGenre(int id);
}
