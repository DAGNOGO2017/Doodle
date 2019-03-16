package Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PreferenceAlimentaire implements Serializable {
	

	@Id
	@GeneratedValue
	private int idPreferenceAlimentaire;
	private String libellePreferenceAlimentaire;
	@ManyToOne
	private Utilisateur utilisateur;
	
	

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
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	

}
