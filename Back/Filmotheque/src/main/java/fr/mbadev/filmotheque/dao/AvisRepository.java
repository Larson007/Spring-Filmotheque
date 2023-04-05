package fr.mbadev.filmotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.mbadev.filmotheque.bo.Avis;

public interface AvisRepository extends JpaRepository<Avis, Integer> {

}
