package jpa;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import test.testjpa.domain.Allergie;
import test.testjpa.domain.Createur;
import test.testjpa.domain.Dates;
import test.testjpa.domain.LieuReunion;
import test.testjpa.domain.Participant;
import test.testjpa.domain.PreferenceAlimentaire;
import test.testjpa.domain.Reunion;
import test.testjpa.domain.Sondage;
import test.testjpa.domain.SondageDate;
import test.testjpa.domain.SondageLieu;
import test.testjpa.domain.Utilisateur;


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
			test.createDatas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listAllergie();
			
   	 manager.close();
		System.out.println(".. done");
	}

	private void createDatas() {

			Utilisateur utilisateur1 = new Createur();
			utilisateur1.setNom("DAGNOGO");
			utilisateur1.setPrenom("kiko");
			//utilisateur1.setEmail("kikodagnogo@gmail.com");
			manager.persist(utilisateur1);

			Participant utilisateur2 = new Participant();
			utilisateur2.setNom("KONAN");
			utilisateur2.setPrenom("ANDERSON");
			utilisateur2.setEmailUtilisateur("andersonkonan@gmail.com");
			manager.persist(utilisateur2);

			LieuReunion lieu1 = new LieuReunion();
			lieu1.setLibelleLieu("Rennes");
			manager.persist(lieu1);

			LieuReunion lieu2 = new LieuReunion();
			lieu2.setLibelleLieu("Nantes");
			manager.persist(lieu2);
			List<LieuReunion> listLieux = new ArrayList<LieuReunion>();
			listLieux.add(lieu1);
			//listLieux.add(lieu2);
			SondageLieu sondageLieu = new SondageLieu();
			sondageLieu.setListeLieux(listLieux);

			Dates date1 = new Dates();
			date1.setLibelleDate("05-02-2018");
			manager.persist(date1);

			Dates date2 = new Dates();
			date2.setLibelleDate("24-12-2017");
			manager.persist(date2);
			List<Dates> listeDate = new ArrayList<Dates>();
			listeDate.add(date1);
			listeDate.add(date2);
			SondageDate sondageDate = new SondageDate();
			sondageDate.setListeDate(listeDate);


			Allergie allergie = new Allergie();
			allergie.setLibelleAllergie("Doliprane");
			allergie.setUtilisateur(utilisateur1);
			manager.persist(allergie);

			Allergie allergie1 = new Allergie();
			allergie1.setLibelleAllergie("paracétamol");
			allergie1.setUtilisateur(utilisateur2);
			manager.persist(allergie1);

			Allergie allergie2 = new Allergie();
			allergie2.setLibelleAllergie("Quinine");
			allergie2.setUtilisateur(utilisateur1);
			manager.persist(allergie2);

			PreferenceAlimentaire preference1 = new PreferenceAlimentaire();
			preference1.setLibellePreferenceAlimentaire("FOUTOU");
			preference1.setUtilisateur(utilisateur2);
			manager.persist(preference1);

			PreferenceAlimentaire preference2 = new PreferenceAlimentaire();
			preference2.setLibellePreferenceAlimentaire("ATTIEKE");
			preference2.setUtilisateur(utilisateur1);
			manager.persist(preference2);

			Sondage sondage1 = new SondageDate();
			sondage1.setLibelleSondage("Sondage sur la date");
			sondage1.setType("poissons");
			manager.persist(sondage1);

			Sondage sondage2 = new SondageLieu();
			sondage2.setLibelleSondage("Sondage sur le lieu");
			sondage2.setType("Viande");
			manager.persist(sondage2);

			Reunion reunion = new Reunion();
			reunion.setIntitule("Les gestes ecologiques");
			reunion.setResume("Il faut toujours faire le tri des ordures ménagères");
			reunion.setSondage(sondage2);
			manager.persist(reunion);

			Reunion reunion1 = new Reunion();
			reunion1.setIntitule("Les gestes ecologiques");
			reunion1.setResume("Il faut toujours faire le tri des ordures ménagères");
			reunion1.setSondage(sondage1);
			manager.persist(reunion1);


	}
	private void listUser() {
        List<Utilisateur> resultList = manager.createQuery("Select u From Utilisateur u", Utilisateur.class).getResultList();
        System.out.println("nombre d'Utilisateur:" + resultList.size());
        for (Utilisateur next : resultList) {
            System.out.println("prochain utilisateur: " + next);
        }
	}
	private void listAllergie() {
        List<Allergie> resultList = manager.createQuery("Select a From Allergie a", Allergie.class).getResultList();
        System.out.println("nombre d'Allergie:" + resultList.size());
//        for (Allergie next : resultList) {
//            System.out.println("prochain utilisateur: " + next);
//        }
	}
	private void listPreference() {
        List<PreferenceAlimentaire> resultList = manager.createQuery("Select p From PreferenceAlimentaire p", PreferenceAlimentaire.class).getResultList();
        System.out.println("nombre de PreferenceAlimentaire:" + resultList.size());
        for (PreferenceAlimentaire next : resultList) {
            System.out.println("prochaine préference: " + next);
        }
	}
	private void listReunion() {
        List<Reunion> resultList = manager.createQuery("Select r From Reunion r", Reunion.class).getResultList();
        System.out.println("nombre de Reunion:" + resultList.size());
        for (Reunion next : resultList) {
            System.out.println("prochaine réunion: " + next);
        }
	}
	private void listSondage() {
        List<Sondage> resultList = manager.createQuery("Select r From Sondage r", Sondage.class).getResultList();
        System.out.println("nombre de Sondage:" + resultList.size());
        for (Sondage next : resultList) {
            System.out.println("prochain Sondage: " + next);
        }
	}
	private void listChoixDate() {
        List<Dates> resultList = manager.createQuery("Select r From Sondage r", Dates.class).getResultList();
        System.out.println("nombre de choix:" + resultList.size());
        for (Dates next : resultList) {
            System.out.println("prochain choix: " + next);
        }
	}

}
