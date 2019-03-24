package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("SondageDate")
public class SondageDate extends Sondage implements Serializable{
	
	private List<Dates> listeDate = new ArrayList<Dates>();
	
	@ManyToOne
	private Createur createur;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Participant> participants;
	public SondageDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@JsonManagedReference
	@OneToMany(mappedBy="sondageDate" , cascade=CascadeType.ALL)
	public List<Dates> getListeDate() {
		return listeDate;
	}

	public void setListeDate(List<Dates> listeDate) {
		this.listeDate = listeDate;
	}
	@JoinColumn(name ="emailCreateur")
	 public Createur getCreateur() {
		return createur;
	}
	public void setCreateur(Createur createur) {
		this.createur = createur;
	}
	public void addSondageDate(Dates d) {
		 Objects.requireNonNull(d);
		 if(listeDate.contains(d))
			 throw new IllegalArgumentException();
		 this.listeDate.add(d);
		 d.setSondageDate(this);
	 }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createur == null) ? 0 : createur.hashCode());
		result = prime * result + ((listeDate == null) ? 0 : listeDate.hashCode());
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
		SondageDate other = (SondageDate) obj;
		if (createur == null) {
			if (other.createur != null)
				return false;
		} else if (!createur.equals(other.createur))
			return false;
		if (listeDate == null) {
			if (other.listeDate != null)
				return false;
		} else if (!listeDate.equals(other.listeDate))
			return false;
		return true;
	}
}
