package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import DAO.IParticipantDao;
import DAO.ISondageLieuDao;
import Entities.Participant;
import Entities.SondageLieu;
import jpa.EntityManagerHelper;

public class SondageLieuDaoImpl implements ISondageLieuDao {
	private IParticipantDao participantDao;
	private EntityManager em;
	
	public SondageLieuDaoImpl() {
		this.em = EntityManagerHelper.getEntityManager();
		participantDao = new ParticipantDaoImpl();
	}

	public SondageLieu addSl(String idP, SondageLieu sl) {
		Participant p = this.participantDao.getParticipantBId(idP);
		p.getSondageLieux().add(sl);
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

	@Override
	public SondageLieu getSondageLieuById(int id) {
		return em.find(SondageLieu.class, id);
	}

}
