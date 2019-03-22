package Entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("Createur")
@PrimaryKeyJoinColumn(name = "idUser")
public class Createur extends Utilisateur implements Serializable{
	
	public Createur() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
}
