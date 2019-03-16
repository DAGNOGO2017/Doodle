package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import DAO.IParticipantDao;
import Entities.Participant;

public class ParticipantDaoImpl implements IParticipantDao {
	@PersistenceContext
	private EntityManager em;
	public Participant addParticipant(Participant participant) {
		em.persist(participant);
		return participant;
	}

	public void removeParticipant(Participant participant) {
		em.remove(participant);
		
	}

	public void updateParticipant(Participant participant) {
		em.merge(participant);
		
	}

	public List<Participant> getList() {
		String req= "Select p from Participant p";
		Query query = em.createQuery(req, Participant.class);
		List<Participant> participants =query.getResultList();
		return participants;
	}


    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commitTransaction() {
        em.getTransaction().commit();
    }


}
