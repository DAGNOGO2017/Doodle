package Entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Dates implements Serializable {
	@Id
	@GeneratedValue
	private long idDate;
	private String LibelleDate;
	
	@ManyToOne
	private SondageDate sondageDate;
	
	public Dates() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdDate() {
		return idDate;
	}
	public void setIdDate(long idDate) {
		this.idDate = idDate;
	}
	public String getLibelleDate() {
		return LibelleDate;
	}
	public void setLibelleDate(String libelleDate) {
		LibelleDate = libelleDate;
	}
	public SondageDate getSondageDate() {
		return sondageDate;
	}
	public void setSondageDate(SondageDate sondageDate) {
		this.sondageDate = sondageDate;
	}
	

}