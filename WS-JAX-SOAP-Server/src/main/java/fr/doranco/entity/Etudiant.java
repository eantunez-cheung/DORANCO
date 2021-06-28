package fr.doranco.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "etudiant", propOrder = {
		"id",
		"nom",
		"prenom",
		"specialite",
		"age"
})
public class Etudiant {

	@XmlElement(required = false)
	private Integer id;
	
	@XmlElement(required = true)
	private String nom;
	
	@XmlElement(required = true)
	private String prenom;
	
	@XmlElement(required = true)
	private String specialite;
	
	@XmlElement(required = false)
	//@XmlTransient
	private Integer age;
	
	public Etudiant() {
	}

	public Etudiant(String nom, String prenom, String specialite, Integer age) {
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite + ", age="
				+ age + "]";
	}

}
