package fr.doranco.rest.metier;

import java.util.Set;

import fr.doranco.rest.beans.Employe;

public interface IEmployeMetier {

	Employe getEmploye(Integer id) throws Exception;
	Set<Employe> getEmployes() throws Exception;
	Employe addEmploye(Employe employe) throws Exception;

}
