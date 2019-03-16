package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import DAO.ISondageLieuDao;
import Entities.SondageLieu;

public class SondageLieuDaoImpl implements ISondageLieuDao {
	@PersistenceContext
	private EntityManager em;
	public SondageLieu addSl(SondageLieu sl) {
		em.persist(sl);
		return sl;
	}

	public void removeSl(SondageLieu sl) {
		em.remove(sl);
		
	}

	public void updateSl(SondageLieu sl) {
		em.merge(sl);
		
	}

	public List<SondageLieu> getList() {
		String req = "Select sl from SondageLieu sl";
		Query query = em.createQuery(req, SondageLieu.class);
		List<SondageLieu> sondageLieus = query.getResultList();
		return sondageLieus;
	}

}
