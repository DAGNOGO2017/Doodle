package test.testjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "SondageDate")
@PrimaryKeyJoinColumn(name = "id")
public class SondageDate extends Sondage{
	
	private List<Dates> listeDate = new ArrayList<Dates>();
	
	@OneToMany(mappedBy="sondageDate" , cascade=CascadeType.PERSIST)
	public List<Dates> getListeDate() {
		return listeDate;
	}

	public void setListeDate(List<Dates> listeDate) {
		this.listeDate = listeDate;
	}
}
