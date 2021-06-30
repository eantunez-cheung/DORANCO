package fr.doranco.ecommerce.enums;

public enum AlgorithmesCryptagePrincipal {

	DES ("DES"),
	PBE ("PBE"),
	BLOWFISH ("BLOWFISH");
	
	private String algorithme;
	
	private AlgorithmesCryptagePrincipal(String algorithme) {
		this.algorithme = algorithme;
	}
	
	public String getAlgorithme() {
		return this.algorithme;
	}
	
	public static boolean isContains(String algorithm) {

	    for (AlgorithmesCryptagePrincipal algo : AlgorithmesCryptagePrincipal.values()) {
	        if (algo.name().equals(algorithm)) {
	            return true;
	        }
	    }
	    return false;
	}
}
