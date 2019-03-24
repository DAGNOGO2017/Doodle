package DAO;

import java.util.List;

import Entities.Createur;

public interface ICreateurDAO {
	public Createur addCreateur(Createur createur);
	public void removeCreateur(Createur createur);
	public void updateCreateur(Createur createur);
	public Createur getCreateurById(int idC);
	public List<Createur> getList();
}
