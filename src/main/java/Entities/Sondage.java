package Entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Sondage")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_SONDAGE", discriminatorType=DiscriminatorType.STRING)
public abstract class Sondage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private int id;

	private String titre;
	
	private String resume;
	
	private java.sql.Date dateCloture;
	
	
	public Sondage(String titre, String resume, Date dateCloture) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.dateCloture = dateCloture;
	}

	public Sondage() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}

	public java.sql.Date getDateCloture() {
		return dateCloture;
	}
	public void setDateCloture(java.sql.Date dateCloture) {
		this.dateCloture = dateCloture;
	}

}
