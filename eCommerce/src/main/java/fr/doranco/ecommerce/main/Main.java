package fr.doranco.ecommerce.main;

import javax.crypto.SecretKey;

import fr.doranco.ecommerce.cryptage.GenerateKey;
import fr.doranco.ecommerce.entity.beans.Params;
import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.model.dao.IParamsDao;
import fr.doranco.ecommerce.model.dao.ParamsDao;

public class Main {

	
	public static void main(String[] args) {
		
		try {
			IParamsDao paramsDao = new ParamsDao();
			String algo = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
			
			Params params = paramsDao.get(Params.class, 1);
			if (params == null) {
				SecretKey key = GenerateKey.getKey(algo, 56);
				params = new Params(key.getEncoded());
				paramsDao.add(params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
