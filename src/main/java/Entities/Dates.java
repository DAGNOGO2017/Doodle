package Entities;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Dates implements Serializable {
	
	private long idDate;
	
	private java.sql.Date Dates;
	
	private SondageDate sondageDate;
	
	public Dates(Date dates) {
		super();
		this.Dates = dates;
	}
	public Dates() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdDate() {
		return idDate;
	}
	public void setIdDate(long idDate) {
		this.idDate = idDate;
	}
	
	public java.sql.Date getDates() {
		return Dates;
	}
	public void setDates(java.sql.Date dates) {
		Dates = dates;
	}
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id")
	public SondageDate getSondageDate() {
		return sondageDate;
	}
	public void setSondageDate(SondageDate sondageDate) {
		this.sondageDate = sondageDate;
	}
	

}