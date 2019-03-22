package DAO;

import java.util.List;

import Entities.PreferenceAlimentaire;

public interface IPrefAlimentaire {
	public PreferenceAlimentaire addprefAlimentaire(int idParticipant, PreferenceAlimentaire pa);
	public void removeprefAlimentaire(PreferenceAlimentaire pa);
	public void updatePrefAlimentaire(int id, PreferenceAlimentaire pa);
	public List<PreferenceAlimentaire> getList();
}
