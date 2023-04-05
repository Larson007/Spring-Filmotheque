package fr.mbadev.filmotheque.bo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int rating;
	private String commentaire;
	
	public Avis(int rating, String commentaire) {
		this.rating = rating;
		this.commentaire = commentaire;
	}
	
	
}
