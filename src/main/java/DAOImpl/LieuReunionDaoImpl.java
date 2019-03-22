package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DAO.ILieuReunionDao;
import DAO.ISondageLieuDao;
import Entities.LieuReunion;
import Entities.SondageLieu;
import jpa.EntityManagerHelper;

public class LieuReunionDaoImpl implements ILieuReunionDao {
	private EntityManager em;
	private ISondageLieuDao sondageDAO;

	public LieuReunionDaoImpl() {
		this.em = EntityManagerHelper.getEntityManager();
		sondageDAO = new SondageLieuDaoImpl();
	}

	@Override
	public LieuReunion addReunion(int IdSondageLieu, LieuReunion lieureunion) {
		SondageLieu sl = sondageDAO.getSondageLieuById(IdSondageLieu);
		sl.addSondageLieu(lieureunion);
		em.persist(lieureunion);
		return lieureunion;
	}

	public void removeReunion(LieuReunion lieureunion) {
		em.remove(lieureunion);
		
	}

	public void updateReunion(LieuReunion lieureunion) {
		em.merge(lieureunion);
		
	}

	@Override
	public List<LieuReunion> getList() {
		String req = "Select lr from LieuReunion lr";
		Query query = em.createQuery(req, LieuReunion.class);
		@SuppressWarnings("unchecked")
		List<LieuReunion> lieuReunions = query.getResultList();
		return lieuReunions;
	}


}
