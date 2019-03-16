package DAO;

import java.util.List;

import Entities.PreferenceAlimentaire;

public interface IPrefAlimentaire {
	public PreferenceAlimentaire addprefAlimentaire(PreferenceAlimentaire pa);
	public void removeprefAlimentaire(PreferenceAlimentaire pa);
	public void updatePrefAlimentaire(PreferenceAlimentaire pa);
	public List<PreferenceAlimentaire> getList();
}
