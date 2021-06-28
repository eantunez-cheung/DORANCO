package fr.doranco.rest.model.dao;

import java.util.HashSet;
import java.util.Set;

import fr.doranco.rest.beans.Employe;

public class EmployeDAO implements IEmployeDAO {

	@Override
	public Employe getEmploye(Integer id) throws Exception {
		
		Employe employe = new Employe("HUGO", "Victor");
		employe.setId(id);
		return employe;
		
	}

	@Override
	public Set<Employe> getEmployes() throws Exception {
		
		Set<Employe> employes = new HashSet<Employe>();
		
		Employe employe1 = new Employe("HUGO", "Victor");
		employe1.setId(1);
		employes.add(employe1);
		
		Employe employe2 = new Employe("HUGO", "Victor");
		employe2.setId(2);
		employes.add(employe2);
		
		Employe employe3 = new Employe("HUGO", "Victor");
		employe3.setId(3);
		employes.add(employe3);
		
		return employes;
	}

	@Override
	public Employe addEmploye(Employe employe) throws Exception {
		employe.setId(10);
		return employe;
	}



}
