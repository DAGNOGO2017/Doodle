package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listeLieux == null) ? 0 : listeLieux.hashCode());
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
		SondageLieu other = (SondageLieu) obj;
		if (listeLieux == null) {
			if (other.listeLieux != null)
				return false;
		} else if (!listeLieux.equals(other.listeLieux))
			return false;
		return true;
	}

	
}
