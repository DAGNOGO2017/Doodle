package test.testjpa.domain;

import java.util.Collection;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur {

	@Id
	@GeneratedValue
	private int idUser;
    private String nom;
    private String prenom;
  
    @ManyToMany
	 @JoinTable(name = "Utilisateur_Sondage", 
 		   joinColumns = @JoinColumn(name = "idUser"),
 		  inverseJoinColumns = @JoinColumn(name = "id"))
    private Collection<Sondage> sondages;
    
    @OneToMany(mappedBy="utilisateur" , cascade=CascadeType.ALL)
    private Collection<Allergie> allergies;
    
    @OneToMany(mappedBy="utilisateur" , cascade=CascadeType.ALL)
    private Collection<PreferenceAlimentaire> preferenceAlimentaires;
    
    
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

	

	
	public Collection<Allergie> getAllergies() {
		return allergies;
	}
	public void setAllergies(Collection<Allergie> allergies) {
		this.allergies = allergies;
	}
	
	
	public Collection<PreferenceAlimentaire> getPreferenceAlimentaires() {
		return preferenceAlimentaires;
	}
	public void setPreferenceAlimentaires(Collection<PreferenceAlimentaire> preferenceAlimentaires) {
		this.preferenceAlimentaires = preferenceAlimentaires;
	}
	
	public Collection<Sondage> getSondages() {
		return sondages;
	}

	public void setSondages(Collection<Sondage> sondages) {
		this.sondages = sondages;
	}
	
	
	
}
