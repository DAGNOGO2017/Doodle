package DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import DAO.ILieuReunionDao;
import Entities.Reunion;

public class LieuReunionDaoImpl implements ILieuReunionDao {
	@PersistenceContext
	private EntityManager em;
	public Reunion addReunion(Reunion reunion) {
		em.persist(reunion);
		return reunion;
	}

	public void removeReunion(Reunion reunion) {
		em.remove(reunion);
		
	}

	public void updateReunion(Reunion reunion) {
		em.merge(reunion);
		
	}

}
