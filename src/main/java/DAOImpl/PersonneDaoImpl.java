package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DAO.IPersonneDao;
import Entities.Personne;
import jpa.EntityManagerHelper;

public class PersonneDaoImpl implements IPersonneDao {
private EntityManager em;
	
	public PersonneDaoImpl() {
		this.em = EntityManagerHelper.getEntityManager();
	}
	
	
	public Personne addPersonne(Personne personne) {
		EntityManagerHelper.beginTransaction();
		em.persist(personne);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return personne;
	}

	public List<Personne> getList() {
		EntityManagerHelper.beginTransaction();
		String req= "Select p from Personne p";
		Query query = em.createQuery(req, Personne.class);
		List<Personne> personnes =query.getResultList();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return personnes;
	}


}
