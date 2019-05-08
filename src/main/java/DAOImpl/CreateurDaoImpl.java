package DAOImpl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DAO.ICreateurDAO;
import Entities.Createur;
import Entities.SondageDate;
import jpa.EntityManagerHelper;

public class CreateurDaoImpl implements ICreateurDAO {

	private EntityManager em;
	EmailSender emailSender = new EmailSender();
	EmailReader emailReader = new EmailReader();
	public CreateurDaoImpl() {
		super();
		this.em = EntityManagerHelper.getEntityManager();
	}

	public Createur addCreateur(Createur createur) {
		EntityManagerHelper.beginTransaction();
		em.persist(createur);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		emailSender.sendEmail(createur.getEmail(), "kk", "konanjacanderson@gmail.com", null);
		emailReader.readEmails(createur.getEmail(), createur.getPassword(), false, 3);
		return createur;
	}

	public void removeCreateur(Createur createur) {
		EntityManagerHelper.beginTransaction();
		em.remove(createur);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
	}

	public void updateCreateur(Createur createur) {
		EntityManagerHelper.beginTransaction();
		em.merge(createur);
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		
	}

	public List<Createur> getList() {
		String req = "Select c from Createur c";
		Query query = em.createQuery(req, Createur.class);
		List<Createur> createurs =  (List<Createur>) query.getResultList();
		return createurs;
	}

	@Override
	public Createur getCreateurById(String idC) {
		// TODO Auto-generated method stub
		return em.find(Createur.class, idC);
	}

	@Override
	public Boolean isValid(SondageDate id) {
		em.find(SondageDate.class, id);
		System.out.println(em.find(SondageDate.class, id));
		Collection<SondageDate> sondageDates;
		return null;
	}

}
