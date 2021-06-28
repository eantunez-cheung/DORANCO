package fr.doranco.users.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public final class HibernateUtil {

	private static HibernateUtil instance;
	private SessionFactory sessionFactory;
	
	private HibernateUtil() {
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(config.getProperties());
		ServiceRegistry serviceRegistry = registry.build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}
	
	public static synchronized HibernateUtil getInstance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}
}
