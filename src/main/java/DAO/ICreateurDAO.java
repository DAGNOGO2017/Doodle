package DAO;

import java.util.List;

import Entities.Createur;
import Entities.SondageDate;

public interface ICreateurDAO {
	public Createur addCreateur(Createur createur);
	public void removeCreateur(Createur createur);
	public void updateCreateur(Createur createur);
	public Createur getCreateurById(String idC);
	public List<Createur> getList();
	public Boolean isValid(SondageDate id);
}
