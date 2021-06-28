package fr.doranco.ecommerce.model.dao;

import java.util.List;

public interface IEntityFacade<T> {

	void add(T entity) throws Exception;
	T get(Class<T> entity, Integer id) throws Exception;
	List<T> getAll(Class<T> entity) throws Exception;
	void update(T entity) throws Exception;
	void remove(T entity) throws Exception;
}
