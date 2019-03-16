package DAO;

import java.util.List;

import Entities.SondageDate;

public interface ISondageDateDao {
	public SondageDate addSd(SondageDate sd);
	public void removeSd(SondageDate sd);
	public void updateSd(SondageDate sd);
	public List<SondageDate> getList();
}
