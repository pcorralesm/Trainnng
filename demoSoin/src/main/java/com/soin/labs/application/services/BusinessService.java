package com.soin.labs.application.services;

/**
 * Interface from business operations and expose the CRUD operations.
 * 
 * @author Paula Corrales M
 */
public interface BusinessService<T> {

	Iterable<T> listAll();

	T getById(Integer id);

	T save(T entity);
}
