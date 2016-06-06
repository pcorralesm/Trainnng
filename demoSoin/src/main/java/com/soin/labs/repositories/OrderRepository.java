package com.soin.labs.repositories;

import org.springframework.data.repository.CrudRepository;

import com.soin.labs.domains.Order;

/**
 * Interface for Order CRUD operations.
 * 
 * @author Paula Corrales M
 */
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
