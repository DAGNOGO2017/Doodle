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
		em = new EntityManagerHelper().getEntityManager();
		participantDAO = new ParticipantDaoImpl();
	}

	public PreferenceAlimentaire addprefAlimentaire(int IParticipant, PreferenceAlimentaire pa) {
		Participant p = this.participantDAO.getParticipantBId(IParticipant);
		p.addPAlimentaire(pa);
		em.persist(pa);
		return pa;
	}

	public void removeprefAlimentaire(PreferenceAlimentaire pa) {
		em.remove(pa);
	}

	public void updatePrefAlimentaire(int id, PreferenceAlimentaire pa) {
		pa.setIdPreferenceAlimentaire(id);
		em.merge(pa);
	}

	public List<PreferenceAlimentaire> getList() {
		String req = "Select pa from PreferenceAlimentaire pa";
		Query query = em.createQuery(req, PreferenceAlimentaire.class);
		List<PreferenceAlimentaire> preferenceAlimentaires = query.getResultList();
		return preferenceAlimentaires;
	}

}
