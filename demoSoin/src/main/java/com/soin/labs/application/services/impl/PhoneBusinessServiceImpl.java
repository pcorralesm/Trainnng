package com.soin.labs.application.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.soin.labs.application.services.BusinessService;
import com.soin.labs.domains.Phone;
import com.soin.labs.repositories.PhoneRepository;

@Service
@Qualifier("phoneBean")
public class PhoneBusinessServiceImpl implements BusinessService<Phone> {
	private PhoneRepository phoneRepository;

	@Autowired
	public void setPhoneRepository(PhoneRepository orderRepository) {
		this.phoneRepository = orderRepository;
	}

	@Override
	public Iterable<Phone> listAll() {
		return this.phoneRepository.findAll();
	}

	@Override
	public Phone getById(Integer id) {
		return this.phoneRepository.findOne(id);
	}

	@Override
	public Phone save(Phone phone) {
		return this.phoneRepository.save(phone);
	}
}