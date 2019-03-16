package DAO;

import java.util.List;

import Entities.SondageLieu;

public interface ISondageLieuDao {
	public SondageLieu addSl(SondageLieu sl);
	public void removeSl(SondageLieu sl);
	public void updateSl(SondageLieu sl);
	public List<SondageLieu> getList();
}
