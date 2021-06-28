package fr.doranco.jaxrs.model;

import java.util.List;

import fr.doranco.jaxrs.jersey.entity.Employe;

public interface IEmployeDao {

	Employe addEmploye(Employe employe) throws Exception;
	List<Employe> getEmployes() throws Exception;
	Employe getEmployeById(Integer id) throws Exception;
	void updateEmploye(Employe employe) throws Exception;
	void removeEmploye(Integer id) throws Exception;
}
