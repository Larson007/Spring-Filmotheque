package fr.mbadev.filmotheque.service;

import java.util.List;

import fr.mbadev.filmotheque.bo.Participant;

public interface ParticipantService {

	public List<Participant> listeParticipant();
	void saveParticipant(Participant participant) throws Exception;
	public void deleteParticipant(int id);
	public Participant participantById(int id);
}
