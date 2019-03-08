package test.testjpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reunion {
	
	@Id
	@GeneratedValue
	private int idReunion;
	private String intitule;
	private String resume;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sodageId", referencedColumnName = "id")
	private Sondage sondage;
	
	public Reunion(String intitule, String resume) {
		super();
		this.intitule = intitule;
		this.resume = resume;
	}
	
	public Reunion() {
		// TODO Auto-generated constructor stub
	}

	public int getIdReunion() {
		return idReunion;
	}
	public void setIdReunion(int idReunion) {
		this.idReunion = idReunion;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}

	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}


	
}
