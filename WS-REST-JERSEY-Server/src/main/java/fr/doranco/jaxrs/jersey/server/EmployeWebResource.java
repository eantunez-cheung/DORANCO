package fr.doranco.jaxrs.jersey.server;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse.Status;

import fr.doranco.jaxrs.jersey.entity.Employe;
import fr.doranco.jaxrs.model.EmployeDao;
import fr.doranco.jaxrs.model.IEmployeDao;
import fr.doranco.jaxrs.utils.Strings;

@Path("employes")
@Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
public class EmployeWebResource implements IEmployeWebResource {

	private static final String CHARSET = ";charset=UTF-8";
	private IEmployeDao employeDao = new EmployeDao();

	public EmployeWebResource() {
	}

	@Override
	@GET
	public String getInfo() {
		return "Vous avez appelé le web service REST 'Employe' pour récupérer des infos.";
	}

	@Override
	@GET
	@Path("employe-{id}-XML")
	@Produces(MediaType.APPLICATION_XML + CHARSET)
	public String getEmployeXML(@PathParam("id") @DefaultValue("1") Integer id) {
		if (id == null || id <= 0) {
			return "Erreur : L'id doit être positif !";
		}
		try {
			Employe employe = employeDao.getEmployeById(id);
			if (employe != null) {
				return Strings.getEmployeAuFormatXmlString(employe);
			} else {
				return "L'employe avec l'id " + id + " n'existe pas !";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Erreur technique !";
		}
	}

	@Override
	@GET
	@Path("employe-{id}-JSON")
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public String getEmployeJSON(@PathParam("id") Integer id) {
		if (id == null || id <= 0) {
			return "Erreur : L'id doit être positif !";
		}
		try {
			Employe employe = employeDao.getEmployeById(id);
			if (employe != null) {
				return Strings.getEmployeAuFormatJsonString(employe);
			}else {
				return "L'employe avec l'id " + id + " n'existe pas !";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Erreur technique !";
		}
	}

	@Override
	@GET
	@Path("employe-{id}")
	@Produces({ MediaType.APPLICATION_XML + CHARSET, MediaType.APPLICATION_JSON + CHARSET })
	public Response getEmployeJSONtoResponse(@PathParam("id") Integer id) {
		if (id == null || id <= 0) {
			return Response.status(Status.BAD_REQUEST).entity("L'id doit être positif !").build();
		}
		try {
			Employe employe = employeDao.getEmployeById(id);
			if (employe != null) {
				return Response.ok().entity(employe).build();
			} else {
				return Response.status(Status.NOT_FOUND).entity("L'employe avec l'id " + id + " n'existe pas !").build();
			}
		} catch (Exception e) {
			System.out.println(e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erreur technique !").build();
		}
	}

	@Override
	@GET
	@Path("liste")
	@Produces({ MediaType.APPLICATION_XML + CHARSET, MediaType.APPLICATION_JSON + CHARSET })
	public List<Employe> getEmployes() {
		try {
			return employeDao.getEmployes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@POST
	@Path("add")
	@Produces({ MediaType.APPLICATION_JSON + CHARSET, MediaType.APPLICATION_XML + CHARSET })
	@Consumes({ MediaType.APPLICATION_JSON + CHARSET, MediaType.APPLICATION_XML + CHARSET })
	public Response addEmploye(Employe employe) throws URISyntaxException {
		try {
			Employe employeAjoute = employeDao.addEmploye(employe);
			if (employeAjoute != null) {
				return Response.status(Status.CREATED).entity(employeAjoute).build();
			} else {
				return Response.status(Status.INTERNAL_SERVER_ERROR).entity("L'employé n'a pu être ajouté").build();
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return Response
					.status(Status.INTERNAL_SERVER_ERROR)
					.entity("Erreur technique !\n" + e.getMessage())
					.build();
		}
	}

	@Override
	@PUT
	@Path("update")
	@Produces({ MediaType.APPLICATION_XML + CHARSET, MediaType.APPLICATION_JSON + CHARSET})
	@Consumes({ MediaType.APPLICATION_XML + CHARSET, MediaType.APPLICATION_JSON + CHARSET})
	public Response updateEmploye(Employe employe) throws URISyntaxException {
		try {
			employeDao.updateEmploye(employe);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erreur technique !").build();
		}
		return Response.status(Status.ACCEPTED).entity("Modification de l'employé réussi !").build();
	}
	
	

	@Override
	@DELETE
	@Path("delete-{id}")
	@Produces({MediaType.APPLICATION_XML + CHARSET, MediaType.APPLICATION_JSON + CHARSET})
	public Response removeEmploye(@PathParam("id") Integer id) throws URISyntaxException {
		try {
			Employe employe = employeDao.getEmployeById(id);
			if (employe == null) {
				return Response.status(Status.NOT_FOUND).entity("L'employé avec l'id = " + id + " à supprimer n'existe pas !").build();
			}
			employeDao.removeEmploye(id);
			return Response.status(Status.ACCEPTED).entity("Employé supprimé avec succès").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erreur technique !").build();
		}
	}

}
