package fr.doranco.rest.model.dao;

import java.util.Set;

import fr.doranco.rest.beans.Employe;

public interface IEmployeDAO {

	Employe getEmploye(Integer id) throws Exception;
	Set<Employe> getEmployes() throws Exception;
	Employe addEmploye(Employe employe) throws Exception;

}
