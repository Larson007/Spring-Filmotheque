package fr.mbadev.filmotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.mbadev.filmotheque.bo.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
