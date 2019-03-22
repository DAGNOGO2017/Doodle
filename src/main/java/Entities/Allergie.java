package Entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Allergie implements Serializable {
	private int idAllergie;
	private String libelleAllergie;
	private Participant participant;
	
	public Allergie(String libelleAllergie) {
		super();
		this.libelleAllergie = libelleAllergie;
	}
	public Allergie() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdAllergie() {
		return idAllergie;
	}
	public void setIdAllergie(int idAllergie) {
		this.idAllergie = idAllergie;
	}
	public String getLibelleAllergie() {
		return libelleAllergie;
	}
	public void setLibelleAllergie(String libelleAllergie) {
		this.libelleAllergie = libelleAllergie;
	}
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "idUser")
	public Participant getParticipant() {
		return participant;
	}
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAllergie;
		result = prime * result + ((libelleAllergie == null) ? 0 : libelleAllergie.hashCode());
		result = prime * result + ((participant == null) ? 0 : participant.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Allergie other = (Allergie) obj;
		if (idAllergie != other.idAllergie)
			return false;
		if (libelleAllergie == null) {
			if (other.libelleAllergie != null)
				return false;
		} else if (!libelleAllergie.equals(other.libelleAllergie))
			return false;
		if (participant == null) {
			if (other.participant != null)
				return false;
		} else if (!participant.equals(other.participant))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Allergie [idAllergie=" + idAllergie + ", libelleAllergie=" + libelleAllergie + ", participant="
				+ participant + "]";
	}
	
	
	
	
	
	
	

}
