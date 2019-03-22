package Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sondage")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_SONDAGE", discriminatorType=DiscriminatorType.STRING)
public abstract class Sondage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private int id;

	private String libelleSondage;
	
	private java.sql.Date dateCloture;

	private String type;
	
	@OneToOne(mappedBy = "sondage", cascade=CascadeType.ALL)
	private Reunion reunion;
	
	
	private Collection<Utilisateur> utilisateurs;
	
	public Sondage(String libelleSondage) {
		super();
		this.libelleSondage = libelleSondage;
	}
	public Sondage() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getLibelleSondage() {
		return libelleSondage;
	}
	public void setLibelleSondage(String libelleSondage) {
		this.libelleSondage = libelleSondage;
	}
	public void setId(int id) {
		this.id = id;
	}


	public java.sql.Date getDateCloture() {
		return dateCloture;
	}
	public void setDateCloture(java.sql.Date dateCloture) {
		this.dateCloture = dateCloture;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Reunion getReunion() {
		return reunion;
	}
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="sondages")
	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}


}
