package DAO;

import java.util.List;

import Entities.Sondage;

public interface ISondageDao {
	public Sondage addSondage(Sondage sondage);
	public void removeSondage(Sondage sondage);
	public void updateSondage(Sondage sondage);
	public List<Sondage> getList();
}
