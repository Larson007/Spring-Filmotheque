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

import fr.mbadev.filmotheque.bo.Film;
import fr.mbadev.filmotheque.bo.Participant;
import fr.mbadev.filmotheque.service.FilmService;
import fr.mbadev.filmotheque.service.ParticipantService;
import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/api/films")
@CrossOrigin
public class FilmRestController {

	@Autowired
	private FilmService filmService;


	// READ
	@GetMapping
	public List<Film> getFilm(Model model) {
		return filmService.listeFilm();
	}

	// CREATE
	@PostMapping
	public void postFilm(@RequestBody Film filmACreer) throws Exception {
		filmService.saveFilm(filmACreer);
	}

	// DELETE
	@DeleteMapping("/{idFilmAsupprimer}")
	public void deleteFilm(@PathVariable Integer idFilmAsupprimer) {
		if (idFilmAsupprimer != null) {
			filmService.deleteFilm(idFilmAsupprimer);
		}
	}

	// UPDATE
	@PutMapping("/{idFilmAModifier}")
	public void updateFilm(@PathVariable Integer idFilmAModifier, @RequestBody Film film) throws Exception {
		if (idFilmAModifier != null) {
			film.setId(idFilmAModifier);
			filmService.saveFilm(film);
		}
	}

	// READ BY ID
	@GetMapping("/{id}")
	public Film getfilmById(@PathVariable Integer id) {
		return filmService.filmById(id);
	}
}
