package fr.doranco.ecommerce.enums;

public enum TypeUtilisateur {

	CLIENT ("C"),
	MAGASINIER ("M"),
	ADMIN ("A");
	
	private String typeUtilisateur;
	
	private TypeUtilisateur(String typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}
	
	public String getTypeUtilisateur() {
		return this.typeUtilisateur;
	}
}
