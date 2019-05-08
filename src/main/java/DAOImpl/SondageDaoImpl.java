package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DAO.ISondageDao;
import Entities.Sondage;
import jpa.EntityManagerHelper;

public class SondageDaoImpl implements ISondageDao {
	private EntityManager em;
	public SondageDaoImpl() {
		em = EntityManagerHelper.getEntityManager();
	}

	public Sondage addSondage(Sondage sondage) {
		EntityManagerHelper.beginTransaction();
		em.persist(sondage);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return sondage;
	}

	public void removeSondage(Sondage sondage) {
		EntityManagerHelper.beginTransaction();
		em.remove(sondage);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
	}

	public void updateSondage(Sondage sondage) {
		EntityManagerHelper.beginTransaction();
		em.merge(sondage);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
	}

	public List<Sondage> getList() {
		EntityManagerHelper.beginTransaction();
		String req = "Select s from Sondage s";
		Query query = em.createQuery(req, Sondage.class);
		List<Sondage> sondages =query.getResultList();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return sondages;
	}

}
