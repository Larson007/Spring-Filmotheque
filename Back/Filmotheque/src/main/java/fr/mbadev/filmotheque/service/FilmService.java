package fr.mbadev.filmotheque.service;

import java.util.List;

import fr.mbadev.filmotheque.bo.Film;

public interface FilmService {

	public List<Film> listeFilm();
	void saveFilm(Film film) throws Exception;
	public void deleteFilm(int id);
	public Film filmById(int id);
}
