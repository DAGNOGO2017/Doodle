package DAO;

import java.util.List;

import Entities.Reunion;

public interface IReunionDao {
	public Reunion addReunion(Reunion r);
	public void removeReunion(Reunion r);
	public void updateReunion(Reunion r);
	public List<Reunion> getList();
}
