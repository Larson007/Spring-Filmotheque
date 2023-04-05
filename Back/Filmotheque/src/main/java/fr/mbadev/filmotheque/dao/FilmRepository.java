package fr.mbadev.filmotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.mbadev.filmotheque.bo.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {

}
