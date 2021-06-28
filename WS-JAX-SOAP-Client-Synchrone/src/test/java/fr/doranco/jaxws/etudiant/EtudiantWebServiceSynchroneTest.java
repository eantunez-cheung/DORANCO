package fr.doranco.jaxws.etudiant;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;

import fr.doranco.jaxws.webservice.Etudiant;
import fr.doranco.jaxws.webservice.EtudiantService;
import fr.doranco.jaxws.webservice.EtudiantService_Service;
import fr.doranco.jaxws.webservice.Exception_Exception;

public class EtudiantWebServiceSynchroneTest {

	static EtudiantService etutiantPort = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EtudiantService_Service etudiantService = new EtudiantService_Service();
		etutiantPort =  etudiantService.getEtudiantPort();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddEtudiantException1() throws Exception_Exception {
		etutiantPort.addEtudiant(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddEtudiantException2() throws Exception_Exception {
		Etudiant etudiant = new Etudiant();
		etutiantPort.addEtudiant(etudiant);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddEtudiantIllegalArgumentException() throws Exception_Exception {
		Etudiant etudiant = new Etudiant();
		etudiant.setNom("");
		etudiant.setPrenom("");
		etudiant.setSpecialite("");
		etutiantPort.addEtudiant(etudiant);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddEtudiantAgeIllegalArgumentException() throws Exception_Exception {
		Etudiant etudiant = new Etudiant();
		etudiant.setNom("ANTUNEZ");
		etudiant.setPrenom("Esteban");
		etudiant.setSpecialite("Développeur");
		etudiant.setAge(0);
		etutiantPort.addEtudiant(etudiant);
	}
	
	@Test
	public void testAddEtudiant() throws Exception_Exception {
		Etudiant etudiant = new Etudiant();
		etudiant.setNom("ANTUNEZ");
		etudiant.setPrenom("Esteban");
		etudiant.setSpecialite("Développeur");
		etudiant.setAge(21);
		Etudiant etudiantAdded = etutiantPort.addEtudiant(etudiant);
		assertNotNull(etudiantAdded);
		assertNotNull(etudiantAdded.getId());
		assertTrue(etudiantAdded.getId() > 0);
	}
	
	@Test
	public void testGetEtudiants() throws Exception_Exception {
		fail();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetEtudiantByIdIllegalArgumentException1() throws Exception_Exception {
		etutiantPort.getEtudiantById(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetEtudiantByIdIllegalArgumentException2() throws Exception_Exception {
		etutiantPort.getEtudiantById(0);
	}
	
	@Test(expected = Exception.class)
	public void testGetEtudiantByIdException() throws Exception_Exception {
		etutiantPort.getEtudiantById(48);
	}
	
	@Test
	public void testGetEtudiantById() throws Exception_Exception {
		Etudiant etudiant = etutiantPort.getEtudiantById(14);
		assertNotNull(etudiant);
		assertNotNull(etudiant.getId());
		assertTrue(etudiant.getId() > 0);
	}

}
