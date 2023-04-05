package fr.mbadev.filmotheque.bo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String prenom;
	private String nom;
	private boolean acteur;
	private boolean realisateur;
	private String photo;
	private Date naissance;
	@Column(columnDefinition = "text")
	private String biographie;

	// TODO
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable( name = "films_acteurs",
//    joinColumns = @JoinColumn( name = "acteur_id" ),
//    inverseJoinColumns = @JoinColumn( name = "film_id" ) )
//    private List<Film> films = new ArrayList<>();
    
    // TODO
    @ManyToMany(mappedBy = "acteurs")
    private List<Film> films = new ArrayList<>();
    
	
   

}