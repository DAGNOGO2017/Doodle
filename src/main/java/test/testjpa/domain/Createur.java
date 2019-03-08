package test.testjpa.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Createur")
@PrimaryKeyJoinColumn(name = "idUser")
public class Createur extends Utilisateur{
	
	private static final long serialVersionUID = 1L;
}
