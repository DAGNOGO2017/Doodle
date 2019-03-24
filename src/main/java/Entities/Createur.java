package Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("Createur")
@PrimaryKeyJoinColumn(name = "idUser")
public class Createur extends Utilisateur implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "createur",cascade=CascadeType.ALL)
	private Collection<SondageDate> sondagesDates;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "createur",cascade=CascadeType.ALL)
	private Collection<SondageLieu> sondageLieux;
	public Createur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collection<SondageDate> getSondagesDates() {
		return sondagesDates;
	}
	public void setSondagesDates(Collection<SondageDate> sondagesDates) {
		this.sondagesDates = sondagesDates;
	}
	public Collection<SondageLieu> getSondageLieux() {
		return sondageLieux;
	}
	public void setSondageLieux(Collection<SondageLieu> sondageLieux) {
		this.sondageLieux = sondageLieux;
	}

	
	
}
