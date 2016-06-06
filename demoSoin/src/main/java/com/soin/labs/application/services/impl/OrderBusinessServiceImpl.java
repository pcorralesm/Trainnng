package com.soin.labs.application.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.soin.labs.application.services.BusinessService;
import com.soin.labs.domains.Order;
import com.soin.labs.repositories.OrderRepository;
import com.soin.labs.utils.ThreadProcessOrder;

@Service
@Qualifier("orderBean")
public class OrderBusinessServiceImpl implements BusinessService<Order> {

	private OrderRepository orderRepository;
	private Logger log = Logger.getLogger(OrderBusinessServiceImpl.class);

	@Autowired
	public void setOrderRepository(OrderRepository repository) {
		this.orderRepository = repository;
	}

	@Override
	public Iterable<Order> listAll() {
		return this.orderRepository.findAll();
	}

	@Override
	public Order getById(Integer id) {
		return this.orderRepository.findOne(id);
	}

	@Override
	public Order save(Order order) {
		order.setState(Boolean.FALSE);
		order = this.orderRepository.save(order);
		return this.process(order);
	}

	/**
	 * This method process the order and change the status to process
	 * 
	 * @param order
	 *            object to process
	 * @return order
	 */
	public Order process(Order order) {

		//star the process to manage the order and doing something
		new Thread(new ThreadProcessOrder(order)).start();

		order.setState(Boolean.TRUE);
		this.orderRepository.save(order);
		log.info("proccess the order: " + order);
		return order;
	}
}
