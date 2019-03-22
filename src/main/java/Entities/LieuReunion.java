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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idLieu ^ (idLieu >>> 32));
		result = prime * result + ((libelleLieu == null) ? 0 : libelleLieu.hashCode());
		result = prime * result + ((sondageLieu == null) ? 0 : sondageLieu.hashCode());
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
		LieuReunion other = (LieuReunion) obj;
		if (idLieu != other.idLieu)
			return false;
		if (libelleLieu == null) {
			if (other.libelleLieu != null)
				return false;
		} else if (!libelleLieu.equals(other.libelleLieu))
			return false;
		if (sondageLieu == null) {
			if (other.sondageLieu != null)
				return false;
		} else if (!sondageLieu.equals(other.sondageLieu))
			return false;
		return true;
	}
	
	

	
}
