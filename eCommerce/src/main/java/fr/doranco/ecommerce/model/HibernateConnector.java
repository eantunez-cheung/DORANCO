package fr.doranco.ecommerce.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public final class HibernateConnector {

	private static HibernateConnector instance;
	private static SessionFactory sessionFactory;
	
	private HibernateConnector() throws Exception {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
//		IParamsDao paramsDao = new ParamsDao();
//		String algo = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
//		
//		Params params = paramsDao.get(Params.class, 1);
//		if (params == null) {
//			SecretKey key = GenerateKey.getKey(algo, 56);
//			params = new Params(key.getEncoded());
//			paramsDao.add(params);
//		}
		
	}

	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	public static synchronized HibernateConnector getInstance() throws Exception {
		if (instance == null) {
			instance = new HibernateConnector();
		}
		return instance;
	}
	
	public static void shutDown() throws HibernateException {
		if (sessionFactory != null && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
		instance = null;
	}
}
