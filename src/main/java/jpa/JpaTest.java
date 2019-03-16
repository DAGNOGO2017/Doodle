package jpa;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entities.Allergie;
import Entities.Createur;
import Entities.Dates;
import Entities.LieuReunion;
import Entities.Participant;
import Entities.PreferenceAlimentaire;
import Entities.Reunion;
import Entities.Sondage;
import Entities.SondageDate;
import Entities.SondageLieu;
import Entities.Utilisateur;


public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory =   
 			 Persistence.createEntityManagerFactory("sir_tp2v1");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();			
   	 manager.close();
		System.out.println(".. done");
	}
}
