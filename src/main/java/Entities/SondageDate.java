package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "SondageDate")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("SondageDate")
public class SondageDate extends Sondage implements Serializable{
	
	private List<Dates> listeDate = new ArrayList<Dates>();
	@ManyToOne
	private Createur createur;
	
	public SondageDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy="sondageDate" , cascade=CascadeType.ALL)
	public List<Dates> getListeDate() {
		return listeDate;
	}

	public void setListeDate(List<Dates> listeDate) {
		this.listeDate = listeDate;
	}
}
