package test.testjpa.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Allergie {
	private int idAllergie;
	private String libelleAllergie;
	private Utilisateur utilisateur;
	
	public Allergie(String libelleAllergie) {
		super();
		this.libelleAllergie = libelleAllergie;
	}
	public Allergie() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
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
	
	@ManyToOne
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAllergie;
		result = prime * result + ((libelleAllergie == null) ? 0 : libelleAllergie.hashCode());
		result = prime * result + ((utilisateur == null) ? 0 : utilisateur.hashCode());
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
		if (utilisateur == null) {
			if (other.utilisateur != null)
				return false;
		} else if (!utilisateur.equals(other.utilisateur))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Allergie [idAllergie=" + idAllergie + ", libelleAllergie=" + libelleAllergie + ", utilisateur="
				+ utilisateur + "]";
	}
	
	
	
	
	
	
	

}
