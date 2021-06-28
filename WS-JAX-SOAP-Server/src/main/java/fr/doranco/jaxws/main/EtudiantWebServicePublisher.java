package fr.doranco.jaxws.main;

import javax.xml.ws.Endpoint;

import fr.doranco.jaxws.EtudiantService;

public class EtudiantWebServicePublisher {

	public static void main(String[] args) {
		try {
			System.out.println("Publication du service Web 'EtudiantService' en cours...");
			Endpoint.publish("http://localhost:9991/ws/etudiant-service", new EtudiantService());
			System.out.println("Web service 'EtudiantService' publi� avec succ�s.");
		} catch (Exception e) {
			System.err.println("ERROR : Web service non publi�");
			System.err.println(e.getMessage());
		}
	}
}
