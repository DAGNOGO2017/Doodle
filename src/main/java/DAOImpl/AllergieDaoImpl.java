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

	public Allergie addAllergie(int idParticipant, Allergie allergie) {
		Participant p = this.participantDAO.getParticipantBId(idParticipant);
		p.addAllergy(allergie);
		em.persist(allergie);
		return allergie;
	}

	public void removeAllergie(Allergie allergie) {
		em.remove(allergie);
		
	}

	public void updateAllergie(Allergie allergie) {
		em.merge(allergie);
		
	}

	public List<Allergie> getList() {
		String req = "Select a from Allergie a";
		Query query = em.createQuery(req, Allergie.class);
		@SuppressWarnings("unchecked")
		List<Allergie> allergies = query.getResultList();
		return allergies;
	}

}
