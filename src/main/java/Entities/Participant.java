package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@PrimaryKeyJoinColumn(name = "email")
@DiscriminatorValue("Participant")
public class Participant extends Utilisateur implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonManagedReference
	@OneToMany(mappedBy="participant" , cascade=CascadeType.ALL)
	private Collection<Allergie> allergies;
	
	@JsonManagedReference
	@OneToMany(mappedBy="participant", cascade=CascadeType.ALL)
	private Collection<PreferenceAlimentaire> preferenceAlimentaires;
	
	@ManyToMany
	@JoinTable(name = "Participant_SondageDate", 
	   joinColumns = @JoinColumn(name = "emailParticipant"),
	  inverseJoinColumns = @JoinColumn(name = "idSondageDate"))
	private Collection<SondageDate> sondageDates;
	
	@ManyToMany
	@JoinTable(name = "Participant_SondageLieux", 
	   joinColumns = @JoinColumn(name = "emailParticipant"),
	  inverseJoinColumns = @JoinColumn(name = "idSondageLieu"))
	private Collection<SondageLieu> sondageLieux;
	
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	public Collection<SondageDate> getSondageDates() {
		return sondageDates;
	}

	public void setSondageDates(Collection<SondageDate> sondageDates) {
		this.sondageDates = sondageDates;
	}

	public Collection<SondageLieu> getSondageLieux() {
		return sondageLieux;
	}

	public void setSondageLieux(Collection<SondageLieu> sondageLieux) {
		this.sondageLieux = sondageLieux;
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
	
}
