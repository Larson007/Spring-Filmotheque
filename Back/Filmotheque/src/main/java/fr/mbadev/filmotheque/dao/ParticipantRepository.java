package fr.mbadev.filmotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.mbadev.filmotheque.bo.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

}
