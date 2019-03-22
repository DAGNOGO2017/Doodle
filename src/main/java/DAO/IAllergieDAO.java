package DAO;

import java.util.List;

import Entities.Allergie;

public interface IAllergieDAO {
	public Allergie addAllergie(int idParticipant, Allergie allergie);
	public void removeAllergie(Allergie allergie);
	public void updateAllergie(Allergie allergie);
	public List<Allergie> getList();
}
