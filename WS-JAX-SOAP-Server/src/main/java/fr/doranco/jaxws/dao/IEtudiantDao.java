package fr.doranco.jaxws.dao;

import java.util.List;

import fr.doranco.entity.Etudiant;

public interface IEtudiantDao {

	List<Etudiant> getEtudiants() throws Exception;
	Etudiant getEtudiantbyId (Integer id) throws Exception;
	Etudiant addEtudiant (Etudiant etudiant) throws Exception;
}
