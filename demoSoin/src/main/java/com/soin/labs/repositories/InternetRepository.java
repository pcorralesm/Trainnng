package com.soin.labs.repositories;

import org.springframework.data.repository.CrudRepository;

import com.soin.labs.domains.Internet;

/**
 * Interface for Internet CRUD operations.
 * 
 * @author Paula Corrales M
 */
public interface InternetRepository extends CrudRepository<Internet, Integer> {
}
