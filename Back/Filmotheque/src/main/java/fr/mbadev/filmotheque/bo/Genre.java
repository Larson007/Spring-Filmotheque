package fr.mbadev.filmotheque.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	
	public Genre(String libelle) {
		this.libelle = libelle;
	}
	
	
}
