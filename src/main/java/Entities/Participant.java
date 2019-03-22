package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@PrimaryKeyJoinColumn(name = "idUser")
@DiscriminatorValue("Participant")
public class Participant extends Utilisateur implements Serializable{
	private static final long serialVersionUID = 1L;
	@JsonManagedReference
	@OneToMany(mappedBy="participant" , cascade=CascadeType.ALL)
	private Collection<Allergie> allergies;
	@JsonManagedReference
	@OneToMany(mappedBy="participant", cascade=CascadeType.ALL)
	private Collection<PreferenceAlimentaire> preferenceAlimentaires;
	
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String email;
	public Collection<Allergie> getAllergies() {
		return allergies;
	}

	public void setAllergies(Collection<Allergie> allergies) {
		this.allergies = allergies;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<PreferenceAlimentaire> getPreferenceAlimentaires() {
		return preferenceAlimentaires;
	}

	public void setPreferenceAlimentaires(Collection<PreferenceAlimentaire> preferenceAlimentaires) {
		this.preferenceAlimentaires = preferenceAlimentaires;
	}
	
	
	public void addAllergy(Allergie a) {
		Objects.requireNonNull(a);
		if(allergies.contains(a))
			throw new IllegalArgumentException();
		
		this.allergies.add(a);
		a.setParticipant(this);
	}
	
	public void addPAlimentaire(PreferenceAlimentaire pa) {
		Objects.requireNonNull(pa);
		if (preferenceAlimentaires.contains(pa)) 
			throw new IllegalArgumentException();
		this.preferenceAlimentaires.add(pa);
		pa.setParticipant(this);
	}
	 public void addSondage(Sondage s) {
		 Objects.requireNonNull(s);
		
	 }
	
}
