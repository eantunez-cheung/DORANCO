package fr.doranco.ecommerce.main;

import javax.crypto.SecretKey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import fr.doranco.ecommerce.cryptage.GenerateKey;
import fr.doranco.ecommerce.entity.beans.Params;
import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.model.HibernateConnector;
import fr.doranco.ecommerce.model.dao.IParamsDao;
import fr.doranco.ecommerce.model.dao.ParamsDao;

public class Main {

	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		try {
			LOGGER.info("Démarrage du contexte de Hibernate...");
			System.out.println("Coucou");
			HibernateConnector.getInstance().getSession();
			
//			IParamsDao paramsDao = new ParamsDao();
//			String algo = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
//			
//			Params params = paramsDao.get(Params.class, 1);
//			if (params == null) {
//				SecretKey key = GenerateKey.getKey(algo, 56);
//				params = new Params(key.getEncoded());
//				paramsDao.add(params);
//			}
		} catch (Exception e) {
			LOGGER.error("Erreur lors du démarrage du contexte de Hibernate :\n" + e);
		}
		
	}
}
