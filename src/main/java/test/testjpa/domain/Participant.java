package test.testjpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Participant")
@PrimaryKeyJoinColumn(name = "idUser")
public class Participant extends Utilisateur{
	
	
	private static final long serialVersionUID = 1L;
	 @Column(name = "email")
	private String emailUtilisateur;     
	
	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}
}
