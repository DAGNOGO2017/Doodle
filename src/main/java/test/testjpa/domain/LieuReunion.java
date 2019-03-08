package test.testjpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LieuReunion {
	
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
