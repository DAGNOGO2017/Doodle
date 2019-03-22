package DAO;

import java.util.List;

import Entities.LieuReunion;

public interface ILieuReunionDao {
	public LieuReunion addReunion(int idSondageLieu, LieuReunion reunion);
	public void removeReunion(LieuReunion lieureunion);
	public void updateReunion(LieuReunion lieureunion);
	public List<LieuReunion> getList();
	
	
}
