package DAO;

import java.util.List;

import Entities.SondageDate;

public interface ISondageDateDao {
	public SondageDate addSd(String idP, SondageDate sd);
	public void removeSd(SondageDate sd);
	public void updateSd(SondageDate sd);
	public List<SondageDate> getList();
	public SondageDate getSondageDateById(int idsd);
}
