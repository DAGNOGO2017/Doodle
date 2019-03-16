package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import DAO.ICreateurDAO;
import Entities.Createur;

public class CreateurDaoImpl implements ICreateurDAO {
	@PersistenceContext
	private EntityManager em;
	public Createur addCreateur(Createur createur) {
		em.persist(createur);
		return createur;
	}

	public void removeCreateur(Createur createur) {
		em.remove(createur);
		
	}

	public void updateCreateur(Createur createur) {
		em.merge(createur);
		
	}

	public List<Createur> getList() {
		String req = "Select c from Createur c";
		Query query = em.createQuery(req, Createur.class);
		List<Createur> createurs = query.getResultList();
		return createurs;
	}

}
