package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import DAO.IAllergieDAO;
import Entities.Allergie;

public class AllergieDaoImpl implements IAllergieDAO {
	@PersistenceContext
	private EntityManager em;
	public Allergie addAllergie(Allergie allergie) {
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
		List<Allergie> allergies = query.getResultList();
		return allergies;
	}

}
