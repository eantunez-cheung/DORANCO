package fr.doranco.ecommerce.cryptage;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.enums.AlgorithmesCryptageSecondaire;

public final class GenerateKey {

	private GenerateKey() {
	}

	public static final SecretKey getKey(String algorithm, int keySize) throws Exception {
		
		List<AlgorithmesCryptagePrincipal> algosPrincipal = Arrays.asList(AlgorithmesCryptagePrincipal.values());
		List<AlgorithmesCryptageSecondaire> algosSecondaire = Arrays.asList(AlgorithmesCryptageSecondaire.values());

		if (algorithm == null || algorithm.trim().isEmpty()
				|| (!AlgorithmesCryptagePrincipal.isContains(algorithm) && !AlgorithmesCryptageSecondaire.isContains(algorithm))) {

			throw new NoSuchAlgorithmException(
					"Seuls les algorithmes suivants sont autorisés : " + algosPrincipal + algosSecondaire);

		}
		if (keySize <= 0 || (keySize % 8) != 0) {
			throw new IllegalBlockSizeException("La taille de la clé doit être un multiple de 8 bits !");
		}
		KeyGenerator keyGen = null;
		
		switch (algorithm) {

			case "DES":
			case "PBE":
			case "BLOWFISH":
				keyGen = KeyGenerator.getInstance(algorithm);
				keyGen.init(keySize);
				break;
				
			case "DSA":
				
				break;
				
			case "SHA-512":
				
				break;
	
			default:
				throw new NoSuchAlgorithmException();
		}
		return keyGen.generateKey();
		
	}
	

}
