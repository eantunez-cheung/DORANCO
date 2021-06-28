package fr.doranco.rest.jersey.server.provider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;


@Provider
public class AuthenticationFilter implements javax.ws.rs.container.ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;
	
	private Response getAccesDeniedResponse() {
		return Response.status(Response.Status.UNAUTHORIZED)
				.entity("Vous n'avez pas le droit d'accès à cette ressource").build();
	}
	
	private Response getAccesForbiddenResponse() {
		return Response.status(Response.Status.FORBIDDEN)
				.entity("Accès bloqué à tous les utilisateurs !!").build();
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		System.out.println("Classe de WebService invoquée :" + resourceInfo.getResourceClass().getSimpleName());
		System.out.println("Méthode de WebService invoquée :" + resourceInfo.getResourceMethod().getName());

		Method method = resourceInfo.getResourceMethod();
		
		if (!method.isAnnotationPresent(PermitAll.class)) {
			if (method.isAnnotationPresent(DenyAll.class)) {
				requestContext.abortWith(getAccesForbiddenResponse());
				return;
			}
			final MultivaluedMap<String, String> headers = requestContext.getHeaders();

			final List<String> filiale = headers.get("Filiale");
			final String filialeData = filiale.get(0);
			final StringTokenizer tokenizer = new StringTokenizer(filialeData, "::");
			final String nomSociete = tokenizer.nextToken();
			final String paramBlabla = tokenizer.nextToken();
			final String paramBloblo = tokenizer.nextToken();
			final String paramBlibli = tokenizer.nextToken();
			System.out.println("Filiale : " + nomSociete
									+ " | " + paramBlabla 
									+ " | " + paramBloblo
									+ " | " + paramBlibli);

			final List<String> authorization = headers.get("Authorization");
			
			if (authorization == null || authorization.isEmpty()) {
				requestContext.abortWith(getAccesDeniedResponse());
				return;
			}
// Côté client :
//			String userAndPassword = "toto:titi";  //  format : "userName:userPassword"
//			String encodedUserAndPassword = Base64.getEncoder().encodeToString(userAndPassword.getBytes());
//			Response response = invocationBuilder.header("Authorization", encodedUserAndPassword)
//												.header("filiale", "Filiale").get();

			
			final String encodedUserPassword = authorization.get(0);
			
			String userNameAndPassword = new String(Base64.getDecoder().decode(encodedUserPassword.getBytes()));
			
			final StringTokenizer tokenizerUserPassword = new StringTokenizer(userNameAndPassword, "::");
			final String username = tokenizerUserPassword.nextToken();
			final String password = tokenizerUserPassword.nextToken();
			
			System.out.println("username : " + username);
			System.out.println("password : " + password);
			
			if (method.isAnnotationPresent(RolesAllowed.class)) {
				RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
				Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAllowed.value()));
				
				if (!isUserAllowed(username, password, rolesSet)) {
					requestContext.abortWith(getAccesDeniedResponse());
					return;
				}
			}
		}
	}
	
	private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet) {
		
		boolean isAllowed = false;
		
		// Vérifier si le user existe dans la BDD et que son mot de passe est correct
		if (username.equals("toto") && password.equals("titi")) {
			
			// Récupérer le rôle de cet utilisateur de la BDD
			String userRole = "ADMIN";
			
			if (rolesSet.contains("ADMIN")) {
				isAllowed = true;
			}
		}
		return isAllowed;
	}
	
	
}
