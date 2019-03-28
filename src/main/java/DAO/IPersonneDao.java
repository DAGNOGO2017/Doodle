package DAO;

import java.util.List;

import Entities.Personne;

public interface IPersonneDao {
	public Personne addPersonne(Personne personne);
	public List<Personne> getList();

}
