package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
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
		EntityManagerHelper.beginTransaction();
		SondageDate sondageDate = this.SondageDAO.getSondageDateById(IdSondageDate);
		sondageDate.addSondageDate(dates);
		em.persist(dates);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return dates;
	}

	public void removeDates(Dates dates) {
		EntityManagerHelper.beginTransaction();
		em.remove(dates);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
	}

	public void updateDates(Dates dates) {
		EntityManagerHelper.beginTransaction();
		em.merge(dates);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
	}

	public List<Dates> getList() {
		EntityManagerHelper.beginTransaction();
		String req = "Select d from Dates d";
		Query query = em.createQuery(req, Dates.class);
		List<Dates> dates = query.getResultList();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return dates;
	}

}
