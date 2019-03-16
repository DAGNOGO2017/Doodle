package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import DAO.IPrefAlimentaire;
import Entities.PreferenceAlimentaire;

public class PrefAlimentaireDaoImpl implements IPrefAlimentaire {
	@PersistenceContext
	private EntityManager em;
	
	public PreferenceAlimentaire addprefAlimentaire(PreferenceAlimentaire pa) {
		em.persist(pa);
		return pa;
	}

	public void removeprefAlimentaire(PreferenceAlimentaire pa) {
		em.remove(pa);
	}

	public void updatePrefAlimentaire(PreferenceAlimentaire pa) {
		em.merge(pa);
	}

	public List<PreferenceAlimentaire> getList() {
		String req = "Select pa from PreferenceAlimentaire pa";
		Query query = em.createQuery(req, PreferenceAlimentaire.class);
		List<PreferenceAlimentaire> preferenceAlimentaires = query.getResultList();
		return preferenceAlimentaires;
	}

}
