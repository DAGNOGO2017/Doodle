package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name = "SondageLieu")
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue("SondageLieu")
public class SondageLieu extends Sondage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Collection<LieuReunion> listeLieux;
	
	public SondageLieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@JsonManagedReference
	@OneToMany(mappedBy="sondageLieu" , cascade=CascadeType.ALL)
	public Collection<LieuReunion> getListeLieux() {
		return listeLieux;
	}

	public void setListeLieux(Collection<LieuReunion> listeLieux) {
		this.listeLieux = listeLieux;
	}

	
	 public void addSondageLieu(LieuReunion lr) {
		 Objects.requireNonNull(lr);
		 if(listeLieux.contains(lr))
			 throw new IllegalArgumentException();
		 this.listeLieux.add(lr);
		 lr.setSondageLieu(this);
	 }

	
}
