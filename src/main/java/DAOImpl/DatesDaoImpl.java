package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import DAO.IDatesDao;
import DAO.ISondageDateDao;
import Entities.Dates;
import Entities.SondageDate;
import jpa.EntityManagerHelper;

public class DatesDaoImpl implements IDatesDao {
	private ISondageDateDao SondageDAO;
	private EntityManager em;
	public DatesDaoImpl() {
		em = EntityManagerHelper.getEntityManager();
		SondageDAO = new SondageDateDaoImpl();
	}

	@Override
	public Dates addDates(int IdSondageDate, Dates dates) {
		SondageDate sondageDate = this.SondageDAO.getSondageDateById(IdSondageDate);
		sondageDate.addSondageDate(dates);
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
