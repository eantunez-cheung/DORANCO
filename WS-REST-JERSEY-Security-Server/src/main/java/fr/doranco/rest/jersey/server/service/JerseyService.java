package fr.doranco.rest.jersey.server.service;

import java.util.Set;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.doranco.rest.beans.Employe;
import fr.doranco.rest.metier.EmployeMetier;
import fr.doranco.rest.metier.IEmployeMetier;

@Path("employes")
@Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
public class JerseyService implements IJerseyService{

	private final String CHARSET = ";charset=UTF-8";

	IEmployeMetier employeMetier = new EmployeMetier();
	
	@Override
	@GET
	@Path("infos")
	public String getInfo() {
		return "Hello from DORANCO, these are General infos.";
	}

	@DenyAll
	@Override
	@GET
	@Path("denied-infos")
	public String getDeniedInfo() {
		return "Hello from DORANCO :)";
	}

	@RolesAllowed({"USER", "CLIENT"})
	@Override
	@GET
	@Path("get-{id}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response getEmployeById(@PathParam("id") Integer id) {
		
		try {
			Employe employe = employeMetier.getEmploye(id);
			return Response.ok(employe).build();
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity("Erreur Technique du serveur !")
						.build();
		}
	}

	@Override
	@GET
	@Path("get-mdp-{id}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response getEmployeById_MDP(@PathParam("id") Integer id) {
		return null;
	}

	@PermitAll
	@Override
	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response getEmployes() {
		try {
			Set<Employe> employes = employeMetier.getEmployes();
			return Response.ok(new GenericEntity<Set<Employe>>(employes){}).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity("Erreur Technique du serveur !")
						.build();
		}
	}

	@Override
	@GET
	@Path("getAllInOne")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response getAllEmployes() {
		return null;
	}

	@Override
	@POST
	@Path("post")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	public Response addEmploye(Employe employe) {
		return null;
	}

	@Override
	@PUT
	@Path("put")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	public Response updateEmploye(Employe employe) {
		return null;
	}

	@Override
	@DELETE
	@Path("delete-{id}")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response removeEmployeById(@PathParam("id") Integer id) {
		return null;
	}
}
