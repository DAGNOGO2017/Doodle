package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import DAO.IDatesDao;
import Entities.Dates;

public class DatesDaoImpl implements IDatesDao {
	@PersistenceContext
	private EntityManager em;
	public Dates addDates(Dates dates) {
		em.persist(dates);
		return dates;
	}

	public void removeDates(Dates dates) {
		em.remove(dates);
		
	}

	public void updateDates(Dates dates) {
		em.merge(dates);
		
	}

	public List<Dates> getList() {
		String req = "Select d from Dates d";
		Query query = em.createQuery(req, Dates.class);
		List<Dates> dates = query.getResultList();
		return dates;
	}

}
