package Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Createur")
@PrimaryKeyJoinColumn(name = "idUser")
public class Createur extends Utilisateur implements Serializable{
	
	private static final long serialVersionUID = 1L;
}
