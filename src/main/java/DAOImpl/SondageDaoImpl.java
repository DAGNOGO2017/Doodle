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
		em.persist(sondage);
		return sondage;
	}

	public void removeSondage(Sondage sondage) {
		em.remove(sondage);
		
	}

	public void updateSondage(Sondage sondage) {
		em.merge(sondage);
		
	}

	public List<Sondage> getList() {
		String req = "Select s from Sondage s";
		Query query = em.createQuery(req, Sondage.class);
		List<Sondage> sondages =query.getResultList();
		return sondages;
	}

}
