package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import DAO.ISondageDateDao;
import Entities.SondageDate;
import jpa.EntityManagerHelper;

public class SondageDateDaoImpl implements ISondageDateDao {
	private EntityManager em;
	public SondageDateDaoImpl() {
		this.em = EntityManagerHelper.getEntityManager();
	}
	public SondageDate addSd(SondageDate sd) {
		em.persist(sd);
		return sd;
	}

	public void removeSd(SondageDate sd) {
		em.remove(sd);
		
	}

	public void updateSd(SondageDate sd) {
		em.merge(sd);
		
	}

	public List<SondageDate> getList() {
		String req = "Select sd from SondageDate sd";
		Query query = em.createQuery(req, SondageDate.class);
		List<SondageDate> sondageDates = query.getResultList();
		return sondageDates;
	}

	@Override
	public SondageDate getSondageDateById(int idsd) {
		// TODO Auto-generated method stub
		return em.find(SondageDate.class, idsd);
	}

}
