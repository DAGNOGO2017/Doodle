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
public class LieuReunion implements Serializable {
	
	
	private long idLieu;
	private String libelleLieu;
	private SondageLieu sondageLieu;
	
	public LieuReunion(String libelleLieu) {
		super();
		this.libelleLieu = libelleLieu;
		// TODO Auto-generated constructor stub
	}
	public LieuReunion() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdLieu() {
		return idLieu;
	}
	public void setIdLieu(long idLieu) {
		this.idLieu = idLieu;
	}
	public String getLibelleLieu() {
		return libelleLieu;
	}
	public void setLibelleLieu(String libelleLieu) {
		this.libelleLieu = libelleLieu;
	}

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id")
	public SondageLieu getSondageLieu() {
		return sondageLieu;
	}


	public void setSondageLieu(SondageLieu sondageLieu) {
		this.sondageLieu = sondageLieu;
	}
	
	

	
}
