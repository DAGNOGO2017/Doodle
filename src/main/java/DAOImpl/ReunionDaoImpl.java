package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import DAO.IReunionDao;
import Entities.Reunion;

public class ReunionDaoImpl implements IReunionDao {
	@PersistenceContext
	private EntityManager em;
	public Reunion addReunion(Reunion r) {
		em.persist(r);
		return r;
	}

	public void removeReunion(Reunion r) {
		em.remove(r);
		
	}

	public void updateReunion(Reunion r) {
		em.merge(r);
		
	}

	public List<Reunion> getList() {
		String req = "Select r from Reunion r";
		Query query = em.createQuery(req, Reunion.class);
		List<Reunion> reunions = query.getResultList();
		return reunions;
	}

}
