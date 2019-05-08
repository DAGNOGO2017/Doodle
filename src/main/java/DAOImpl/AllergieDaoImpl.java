 package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DAO.IAllergieDAO;
import DAO.IParticipantDao;
import Entities.Allergie;
import Entities.Participant;
import jpa.EntityManagerHelper;

public class AllergieDaoImpl implements IAllergieDAO {
	
	private IParticipantDao participantDAO;
	private EntityManager em;

	public AllergieDaoImpl( ) {
		em = EntityManagerHelper.getEntityManager();
		participantDAO = new ParticipantDaoImpl();
	}

	public Allergie addAllergie(String idParticipant, Allergie allergie) {
		EntityManagerHelper.beginTransaction();
		Participant p = this.participantDAO.getParticipantBId(idParticipant);
		p.addAllergy(allergie);
		em.persist(allergie);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return allergie;
	}

	public void removeAllergie(Allergie allergie) {
		EntityManagerHelper.beginTransaction();
		em.remove(allergie);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
	}

	public void updateAllergie(Allergie allergie) {
		EntityManagerHelper.beginTransaction();
		em.merge(allergie);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
	}

	public List<Allergie> getList() {
		EntityManagerHelper.beginTransaction();
		String req = "Select a from Allergie a";
		Query query = em.createQuery(req, Allergie.class);
		@SuppressWarnings("unchecked")
		List<Allergie> allergies = query.getResultList();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
		return allergies;
	}

}
