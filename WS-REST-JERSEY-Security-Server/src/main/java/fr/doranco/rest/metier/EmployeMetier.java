package fr.doranco.rest.metier;

import java.util.HashSet;
import java.util.Set;

import fr.doranco.rest.beans.Employe;
import fr.doranco.rest.model.dao.EmployeDAO;
import fr.doranco.rest.model.dao.IEmployeDAO;

public class EmployeMetier implements IEmployeMetier {

	private final IEmployeDAO employeDao = new EmployeDAO();
	
	@Override
	public Employe getEmploye(Integer id) throws Exception {
		
		return employeDao.getEmploye(id);
		
	}

	@Override
	public Set<Employe> getEmployes() throws Exception {
		
		return employeDao.getEmployes();
	}

	@Override
	public Employe addEmploye(Employe employe) throws Exception {
		return employeDao.addEmploye(employe);
	}



}
