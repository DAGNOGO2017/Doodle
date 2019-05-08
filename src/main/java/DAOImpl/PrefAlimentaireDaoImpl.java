package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DAO.IParticipantDao;
import DAO.IPrefAlimentaire;
import Entities.Participant;
import Entities.PreferenceAlimentaire;
import jpa.EntityManagerHelper;

public class PrefAlimentaireDaoImpl implements IPrefAlimentaire {
	private IParticipantDao participantDAO;
	
	private EntityManager em;
	
	public PrefAlimentaireDaoImpl() {
		participantDAO = new ParticipantDaoImpl();
	}

	public PreferenceAlimentaire addprefAlimentaire(String IParticipant, PreferenceAlimentaire pa) {
		EntityManagerHelper.beginTransaction();
		Participant p = this.participantDAO.getParticipantBId(IParticipant);
		p.addPAlimentaire(pa);
		em.persist(pa);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return pa;
	}

	public void removeprefAlimentaire(PreferenceAlimentaire pa) {
		EntityManagerHelper.beginTransaction();
		em.remove(pa);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
	}

	public void updatePrefAlimentaire(int id, PreferenceAlimentaire pa) {
		EntityManagerHelper.beginTransaction();
		pa.setIdPreferenceAlimentaire(id);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		em.merge(pa);
	}

	public List<PreferenceAlimentaire> getList() {
		EntityManagerHelper.beginTransaction();
		String req = "Select pa from PreferenceAlimentaire pa";
		Query query = em.createQuery(req, PreferenceAlimentaire.class);
		List<PreferenceAlimentaire> preferenceAlimentaires = query.getResultList();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return preferenceAlimentaires;
	}

}
