package fr.doranco.filrouge.ws.rest.server;

import java.util.List;

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

import fr.doranco.filrouge.entity.Utilisateur;

@Path("users")
@Produces(MediaType.TEXT_PLAIN + ";charset=UTF-8")
public class UtilisateurWebResource implements IUtilisateurWebResource {

	@Override
	@GET
	public String getInfos() {
		return "Web Services for 'Utilisateur'";
	}

	@Override
	@GET
	@Path("get/{identifiant}")
	@Produces({MediaType.APPLICATION_JSON + CHARSET, MediaType.APPLICATION_XML + CHARSET})
	public Response getUtilisateur(@PathParam("identifiant") Integer id) {
		if (id <= 0) {
			return Response.status(Status.BAD_REQUEST)
					.entity("L'id de l'utilisateur � r�cup�rer doit �tre > 0 !")
					.build();
		}
		// bouchon
		Utilisateur user = new Utilisateur("Toto", "titi");  // utilisateurDao.getUtilisateur(id);
		user.setId(id);
		//return Response.status(Status.OK).entity(user).build();
		return Response.ok(user).build();
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response addUtilisateur(Utilisateur utilisateur) {
		
		if (utilisateur == null) {
			return Response.status(Status.NO_CONTENT)
						.entity("L'utilisateur � ajouter ne doit pas �tre nul !")
						.build();
		}
		if (utilisateur.getNom() == null || utilisateur.getNom().isEmpty()
				|| utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty()) {
			
			return Response.status(Status.BAD_REQUEST)
					.entity("Tous les attributs del'utilisateur � ajouter sont obligatoires !")
					.build();
		}
		// bouchon
		utilisateur.setId(1);	// utilisateurDao.add(utilisateur);
		return Response.status(Status.CREATED).entity(utilisateur).build();
	}

	@Override
	@Path("addUsers")
	@POST
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response addUtilisateurs(List<Utilisateur> utilisateurs) {
		
		if (utilisateurs == null || utilisateurs.isEmpty()) {
			return Response.status(Status.NO_CONTENT)
						.entity("La liste des utilisateurs � ajouter ne doit pas �tre nulle ou vide !")
						.build();
		}
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getNom() == null || utilisateur.getNom().isEmpty()
					|| utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty()) {
				
				return Response.status(Status.BAD_REQUEST)
						.entity("Tous les attributs d'un utilisateur � ajouter sont obligatoires !")
						.build();
			}
		}
		// bouchon
		int i = 1;
		for (Utilisateur utilisateur : utilisateurs) {
			utilisateur.setId(i++);	// utilisateurDao.add(utilisateur);
		}
		return Response.status(Status.CREATED)
					.entity(new GenericEntity<List<Utilisateur>>(utilisateurs){})
					.build();

	}

	@Override
	@PUT
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response updateUtilisateur(Utilisateur utilisateur) {
		
		if (utilisateur == null) {
			return Response.status(Status.NO_CONTENT)
						.entity("L'utilisateur � mettre � jour ne doit pas �tre nul !")
						.build();
		}
		if (utilisateur.getId() == null || utilisateur.getId() <= 0) {
			return Response.status(Status.BAD_REQUEST)
					.entity("L'id de l'utilisateur � mettre � jour doit �tre > 0 !")
					.build();
		}
		if (utilisateur.getNom() == null || utilisateur.getNom().isEmpty()
				|| utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty()) {
			
			return Response.status(Status.BAD_REQUEST)
					.entity("Tous les attributs de l'utilisateur � mettre � jour sont obligatoires !")
					.build();
		}
		// bouchon
		utilisateur.setNom(utilisateur.getNom() + "-modifi�");
		utilisateur.setPrenom(utilisateur.getPrenom() + "-modifi�");
			// utilisateurDao.update(utilisateur);
		return Response.status(Status.ACCEPTED)
					.entity(utilisateur)
					.build();

	}

	@Override
	@Path("updatePrenom/{id}/{prenom}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response updateUtilisateurPrenom(@PathParam("id") Integer id, @PathParam("prenom") String prenom) {
		
		if (id == null || id <= 0) {
			return Response.status(Status.BAD_REQUEST)
					.entity("L'id de l'utilisateur � mettre � jour doit �tre > 0 !")
					.build();
		}
		if (prenom == null || prenom.trim().isEmpty()) {
			return Response.status(Status.BAD_REQUEST)
					.entity("Le prenom de l'utilisateur � mettre � jour est obligatoire !")
					.build();
		}
		// bouchon
		Utilisateur user = new Utilisateur("Toto", "titi");
		user.setId(id);
			// Utilisateur utilisateurToUpdate = utilisateurDao.getUtilisateur(id);
			//		if (utilisateurToUpdate == null) {
			//			return Response.status(Status.BAD_REQUEST)
			//					.entity("L'utilisateur � mettre � jour n'existe pas !")
			//					.build();
			//		}
			// utilisateurToUpdate.setPrenom(prenom);
		
			user.setPrenom(prenom);
			// utilisateurDao.update(utilisateurToUpdate);
			
		return Response.status(Status.ACCEPTED)
					.entity(user)
					.build();
		
	}

	@Override
	@Path("delete/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON + CHARSET)
	@Produces(MediaType.APPLICATION_JSON + CHARSET)
	public Response removeUtilisateur(@PathParam("id") Integer id) {
		
		if (id == null || id <= 0) {
			return Response.status(Status.BAD_REQUEST)
					.entity("L'id de l'utilisateur � supprimer doit �tre > 0 !")
					.build();
		}
		// bouchon
		//pas de bouchon n�cessaire mais juste on renvoie la r�ponse comme quoi c� �t� effectu�.
			// Utilisateur utilisateurToRemove = utilisateurDao.getUtilisateur(id);
			//		if (utilisateurToRemove == null) {
			//			return Response.status(Status.BAD_REQUEST)
			//					.entity("L'utilisateur � supprimer n'existe pas !")
			//					.build();
			//		}
			// utilisateurDao.remove(id);
		return Response.status(Status.ACCEPTED)
				.entity("L'utilisateur (" + id + ") a bien �t� supprim�")
				.build();
	}

}
