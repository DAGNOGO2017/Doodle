package test.testjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "SondageLieu")
@PrimaryKeyJoinColumn(name = "id")
public class SondageLieu extends Sondage{
	
	private static final long serialVersionUID = 1L;
	
	
	private List<LieuReunion> listeLieux= new ArrayList<LieuReunion>();

	@OneToMany(mappedBy="sondageLieu" , cascade=CascadeType.PERSIST)
	public List<LieuReunion> getListeLieux() {
		return listeLieux;
	}

	public void setListeLieux(List<LieuReunion> listeLieux) {
		this.listeLieux = listeLieux;
	}


	
}
