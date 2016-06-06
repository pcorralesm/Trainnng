package com.soin.labs.application.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.soin.labs.application.services.BusinessService;
import com.soin.labs.domains.Product;
import com.soin.labs.repositories.ProductRepository;

@Service
@Qualifier("productBean")
public class ProductBusinessServiceImpl implements BusinessService<Product> {
	private ProductRepository productRepository;

	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Iterable<Product> listAll() {
		return this.productRepository.findAll();
	}

	@Override
	public Product getById(Integer id) {
		return this.productRepository.findOne(id);
	}

	@Override
	public Product save(Product product) {
		return this.productRepository.save(product);
	}
}
