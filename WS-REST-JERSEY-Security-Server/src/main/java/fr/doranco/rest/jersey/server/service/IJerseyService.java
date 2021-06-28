package fr.doranco.rest.jersey.server.service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Response;

import fr.doranco.rest.beans.Employe;
import fr.doranco.rest.beans.Employes;

public interface IJerseyService {

	String getInfo();
	String getDeniedInfo();
	Response getEmployeById(Integer id);
	Response getEmployeById_MDP(Integer id) ;
	Response getEmployes() ;
	Response getAllEmployes();
	Response addEmploye(Employe employe);
	Response updateEmploye(Employe employe) ;
	Response removeEmployeById(Integer id);
	
}
