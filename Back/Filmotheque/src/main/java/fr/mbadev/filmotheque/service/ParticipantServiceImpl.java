package fr.mbadev.filmotheque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.mbadev.filmotheque.bo.Participant;
import fr.mbadev.filmotheque.dao.ParticipantRepository;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	private ParticipantRepository participantRepository;
	
	@Override
	public List<Participant> listeParticipant() {
		return participantRepository.findAll();
	}

	@Override
	public void saveParticipant(Participant participant) throws Exception {
		participantRepository.save(participant);

	}

	@Override
	public void deleteParticipant(int id) {
		participantRepository.deleteById(id);

	}

	@Override
	public Participant participantById(int id) {
		return participantRepository.findById(id).get();
	}

}
