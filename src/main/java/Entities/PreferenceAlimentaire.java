package Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class PreferenceAlimentaire implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int idPreferenceAlimentaire;
	private String libellePreferenceAlimentaire;
	@JsonBackReference
	@ManyToOne
	private Participant participant;
	public PreferenceAlimentaire(String libellePreferenceAlimentaire) {
		super();
		this.libellePreferenceAlimentaire = libellePreferenceAlimentaire;
	}
	public PreferenceAlimentaire() {
		// TODO Auto-generated constructor stub
	}
	public int getIdPreferenceAlimentaire() {
		return idPreferenceAlimentaire;
	}
	public void setIdPreferenceAlimentaire(int idPreferenceAlimentaire) {
		this.idPreferenceAlimentaire = idPreferenceAlimentaire;
	}
	public String getLibellePreferenceAlimentaire() {
		return libellePreferenceAlimentaire;
	}
	public void setLibellePreferenceAlimentaire(String libellePreferenceAlimentaire) {
		this.libellePreferenceAlimentaire = libellePreferenceAlimentaire;
	}
	public Participant getParticipant() {
		return participant;
	}
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	


	

}
