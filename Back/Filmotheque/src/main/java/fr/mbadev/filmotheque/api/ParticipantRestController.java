package fr.mbadev.filmotheque.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.mbadev.filmotheque.bo.Participant;
import fr.mbadev.filmotheque.service.ParticipantService;

@RestController
@RequestMapping("/api/participants")
@CrossOrigin
public class ParticipantRestController {

	@Autowired
	private ParticipantService partcipantService;
	
	//READ
	@GetMapping
	public List<Participant> getParticipant(Model model){
		return partcipantService.listeParticipant();
	}
	
	//CREATE
	@PostMapping
	public void postParticipant(@RequestBody Participant participantACreer) throws Exception {
		partcipantService.saveParticipant(participantACreer);
	}
	
	// DELETE
	@DeleteMapping("/{idParticipantAsupprimer}")
	public void deleteParticipant(@PathVariable Integer idParticipantAsupprimer) {
		if (idParticipantAsupprimer != null) {
			partcipantService.deleteParticipant(idParticipantAsupprimer);	
		}
	}
	
	// UPDATE
	@PutMapping("/{idParticipantAModifier}")
	public void updatePersonne(@PathVariable Integer idParticipantAModifier, @RequestBody Participant participant) throws Exception {
		if (idParticipantAModifier != null) {
			participant.setId(idParticipantAModifier);
			partcipantService.saveParticipant(participant); 
		}
	}
	
	// READ BY ID
	@GetMapping("/{id}")
	public Participant getParticipantById(@PathVariable Integer id) {
		return partcipantService.participantById(id);
	}
}
