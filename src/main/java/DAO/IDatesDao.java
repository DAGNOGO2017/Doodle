package DAO;

import java.util.List;

import Entities.Dates;

public interface IDatesDao {
	public Dates addDates(Dates dates);
	public void removeDates(Dates dates);
	public void updateDates(Dates dates);
	public List<Dates> getList();
}
