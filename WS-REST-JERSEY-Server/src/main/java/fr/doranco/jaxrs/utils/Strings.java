package fr.doranco.jaxrs.utils;

import org.json.JSONObject;

import fr.doranco.jaxrs.jersey.entity.Employe;

public final class Strings {

	private Strings() {
		
	}

	public static String getEmployeAuFormatXmlString(Employe employe) {
		StringBuilder builder = new StringBuilder();
		builder.append("<employe>");
		builder.append("<id>" + employe.getId() + "</id>");
		builder.append("<nom>" + employe.getNom() + "</nom>");
		builder.append("<prenom>" + employe.getPrenom() + "</prenom>");
		builder.append("<posteOccupe>" + employe.getPosteOccupe() + "</posteOccupe>");
		builder.append("</employe>");
		return builder.toString();
	}
	
	public static String getEmployeAuFormatJsonString(Employe employe) {
		JSONObject object = new JSONObject();
		object.put("id", employe.getId());
		object.put("prenom", employe.getPrenom());
		object.put("nom", employe.getNom());
		object.put("poste occupe", employe.getPosteOccupe());
		return object.toString();
	}
}
