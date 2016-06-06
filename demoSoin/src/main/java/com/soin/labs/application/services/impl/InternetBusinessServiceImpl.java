package com.soin.labs.application.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.soin.labs.application.services.BusinessService;
import com.soin.labs.domains.Internet;
import com.soin.labs.repositories.InternetRepository;

/**
 * Interface for Product CRUD operations.
 * 
 * @author Paula Corrales M
 */
@Service
@Qualifier("internetBean")
public class InternetBusinessServiceImpl implements BusinessService<Internet> {

	private InternetRepository internetRepository;

	@Autowired
	public void setInternetRepository(InternetRepository internetRepository) {
		this.internetRepository = internetRepository;
	}

	@Override
	public Iterable<Internet> listAll() {
		return internetRepository.findAll();
	}

	@Override
	public Internet getById(Integer id) {
		return internetRepository.findOne(id);
	}

	@Override
	public Internet save(Internet entity) {
		return internetRepository.save(entity);
	}
}