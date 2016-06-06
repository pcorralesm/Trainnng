package com.soin.labs.repositories;

import org.springframework.data.repository.CrudRepository;

import com.soin.labs.domains.Phone;

/**
 * Interface for Phone CRUD operations.
 * 
 * @author Paula Corrales M
 */
public interface PhoneRepository extends CrudRepository<Phone, Integer> {
}
