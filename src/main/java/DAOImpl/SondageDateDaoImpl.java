package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DAO.IParticipantDao;
import DAO.ISondageDateDao;
import Entities.Participant;
import Entities.SondageDate;
import jpa.EntityManagerHelper;

public class SondageDateDaoImpl implements ISondageDateDao {
	private IParticipantDao participantDao;
	private EntityManager em;
	public SondageDateDaoImpl() {
		this.em = EntityManagerHelper.getEntityManager();
		participantDao = new ParticipantDaoImpl();
	}
	public SondageDate addSd(String idIp, SondageDate sd) {
		EntityManagerHelper.beginTransaction();
		Participant p = this.participantDao.getParticipantBId(idIp);
		p.getSondageDates().add(sd);
		em.persist(sd);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return sd;
	}

	public void removeSd(SondageDate sd) {
		EntityManagerHelper.beginTransaction();
		em.remove(sd);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
	}

	public void updateSd(SondageDate sd) {
		EntityManagerHelper.beginTransaction();
		em.merge(sd);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
	}

	public List<SondageDate> getList() {
		EntityManagerHelper.beginTransaction();
		String req = "Select sd from SondageDate sd";
		Query query = em.createQuery(req, SondageDate.class);
		List<SondageDate> sondageDates = query.getResultList();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return sondageDates;
	}

	@Override
	public SondageDate getSondageDateById(int idsd) {
		// TODO Auto-generated method stub
		return em.find(SondageDate.class, idsd);
	}

}
