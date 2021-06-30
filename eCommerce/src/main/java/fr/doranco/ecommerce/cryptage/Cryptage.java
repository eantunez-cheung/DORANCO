package fr.doranco.ecommerce.cryptage;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;

public final class Cryptage {

	private Cryptage() {
	}
	
	public static final byte[] encrypt(String algorithm, String messageToEncrypt, SecretKey key) throws Exception {
		if (!AlgorithmesCryptagePrincipal.isContains(algorithm)) {
			throw new NoSuchAlgorithmException("Seuls les algorithmes suivants sont acceptés : "
													+ AlgorithmesCryptagePrincipal.values());
		}
		if (messageToEncrypt == null || messageToEncrypt.trim().isEmpty()) {
			throw new IllegalArgumentException("le message à crypter ne doit pas être nul ou vide !");
		}
		if (key == null) {
			throw new NullPointerException("La clé de cryptage ne doit pas être null !");
		}
		
		Cipher cipher = Cipher.getInstance(AlgorithmesCryptagePrincipal.DES.getAlgorithme());
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] messageBytes = messageToEncrypt.getBytes("UTF-8");
		return cipher.doFinal(messageBytes);
	}
	
	public static final String decrypt(String algorithm, byte[] messageCrypte, SecretKey key) throws Exception {
		
		if (!AlgorithmesCryptagePrincipal.isContains(algorithm)) {
			throw new NoSuchAlgorithmException("Seuls les algorithmes suivants sont acceptés : "
													+ AlgorithmesCryptagePrincipal.values());
		}
		if (messageCrypte == null) {
			throw new IllegalArgumentException("le message à décrypter ne doit pas être nul !");
		}
		if (key == null) {
			throw new NullPointerException("La clé de cryptage ne doit pas être null !");
		}

		Cipher cipher = Cipher.getInstance(AlgorithmesCryptagePrincipal.DES.getAlgorithme());
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] messageDecrypte = cipher.doFinal(messageCrypte);
		return new String(messageDecrypte, "UTF-8");
	}
}
