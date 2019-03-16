package DAO;

import Entities.Reunion;

public interface ILieuReunionDao {
	public Reunion addReunion(Reunion reunion);
	public void removeReunion(Reunion reunion);
	public void updateReunion(Reunion reunion);
	
}
