package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DAO.IParticipantDao;
import Entities.Participant;
import jpa.EntityManagerHelper;

public class ParticipantDaoImpl implements IParticipantDao {
	private EntityManager em;
	//EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
	
	public ParticipantDaoImpl() {
		this.em = EntityManagerHelper.getEntityManager();
	}
	
	
	public Participant addParticipant(Participant participant) {
		EntityManagerHelper.beginTransaction();
		em.persist(participant);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return participant;
	}

	public void removeParticipant(Participant participant) {
		EntityManagerHelper.beginTransaction();
		em.remove(participant);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
	}

	public void updateParticipant(Participant participant) {
		EntityManagerHelper.beginTransaction();
		em.merge(participant);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
	}

	public List<Participant> getList() {
		String req= "Select p from Participant p";
		Query query = em.createQuery(req, Participant.class);
		List<Participant> participants =query.getResultList();
		return participants;
	}

	@Override
	public Participant getParticipantBId(String id) {
		return em.find(Participant.class, id);
	}


}
