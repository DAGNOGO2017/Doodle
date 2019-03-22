package Entities;

import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PERSONNE", discriminatorType=DiscriminatorType.STRING)
public abstract class Utilisateur {

	@Id
	@GeneratedValue
	private int idUser;
    private String nom;
    private String prenom;
  
    @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(name = "Utilisateur_Sondage", 
 		   joinColumns = @JoinColumn(name = "idUser"),
 		  inverseJoinColumns = @JoinColumn(name = "id"))
    private Collection<Sondage> sondages;
  
   
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
    
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Collection<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(Collection<Sondage> sondages) {
		this.sondages = sondages;
	}
	
	
	
}
