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

import fr.mbadev.filmotheque.bo.Genre;
import fr.mbadev.filmotheque.service.GenreService;

@RestController
@RequestMapping("/api/genres")
@CrossOrigin
public class GenreRestController {

	@Autowired
	private GenreService genreService;
	
	//READ
	@GetMapping
	public List<Genre> getGenre(Model model){
		return genreService.listeGenre();
	}
	
	//CREATE
	@PostMapping
	public void postGenre(@RequestBody Genre genreACreer) throws Exception {
		genreService.saveGenre(genreACreer);
	}
	
	// DELETE
	@DeleteMapping("/{idGenreAsupprimer}")
	public void deleteGenre(@PathVariable Integer idGenreAsupprimer) {
		if (idGenreAsupprimer != null) {
			genreService.deleteGenre(idGenreAsupprimer);	
		}
	}
	
	// UPDATE
	@PutMapping("/{idGenreAModifier}")
	public void updateGenre(@PathVariable Integer idGenreAModifier, @RequestBody Genre genre) throws Exception {
		if (idGenreAModifier != null) {
			genre.setId(idGenreAModifier);
			genreService.saveGenre(genre); 
		}
	}

}
