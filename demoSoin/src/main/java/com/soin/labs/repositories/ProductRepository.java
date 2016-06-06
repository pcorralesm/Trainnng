package com.soin.labs.repositories;

import org.springframework.data.repository.CrudRepository;
import com.soin.labs.domains.Product;

/**
 * Interface for Product CRUD operations.
 * 
 * @author Paula Corrales M
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
