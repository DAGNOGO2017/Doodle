package Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LieuReunion implements Serializable {
	
	@Id
	@GeneratedValue
	private long idLieu;
	private String libelleLieu;
	
	@ManyToOne
	private SondageLieu sondageLieu;
	
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

	
}
