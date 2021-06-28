package fr.doranco.users.model.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.users.model.HibernateConnector;

public abstract class AbstractEntityFacade<T> implements IEntityFacade<T> {

	@Override
	public void add(T entity) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}

	@Override
	public T get(Class<T> entity, Integer id) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		T returnEntity = session.get(entity, id);
		if (session != null && session.isOpen()) {
			session.close();
		}
		return returnEntity;
	}

	@Override
	public List<T> getAll(Class<T> entity) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(entity);
		criteriaQuery.from(entity);
		Query<T> query = session.createQuery(criteriaQuery);
		List<T> liste = query.getResultList();
		if (session != null && session.isOpen()) {
			session.close();
		}
		return liste;
	}

	@Override
	public void update(T entity) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}

	@Override
	public void remove(T entity) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		if (session != null && session.isOpen()) {
			session.close();
		}
	}

}
