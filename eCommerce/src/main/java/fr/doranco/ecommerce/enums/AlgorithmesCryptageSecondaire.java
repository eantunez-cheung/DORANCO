package fr.doranco.ecommerce.enums;

public enum AlgorithmesCryptageSecondaire {

	DSA ("DSA"),
	MD5 ("MD5"),
	SHA_512 ("SHA-512");
	
	private String algorithme;
	
	private AlgorithmesCryptageSecondaire(String algorithme) {
		this.algorithme = algorithme;
	}
	
	public String getAlgorithme() {
		return this.algorithme;
	}
	
	public static boolean isContains(String algorithm) {

	    for (AlgorithmesCryptageSecondaire algo : AlgorithmesCryptageSecondaire.values()) {
	        if (algo.name().equals(algorithm)) {
	            return true;
	        }
	    }
	    return false;
	}
}
