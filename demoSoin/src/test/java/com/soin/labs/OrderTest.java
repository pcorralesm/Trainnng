package com.soin.labs;

import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.soin.labs.domains.Order;
import com.soin.labs.repositories.OrderRepository;
import com.soin.labs.repositories.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoSoinWebApplication.class)
@WebAppConfiguration
public class OrderTest {

	private OrderRepository orderRepository;
	private Logger log = Logger.getLogger(OrderTest.class);
	Random randomGenerator = new Random();
	private ProductRepository productRepository;

	@Autowired
	public void setInternetRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Autowired
	public void setPhoneRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	/**
	 * This test verify the save phone method in the Phone Repository
	 */
	@Test
	public void createOrder() {

		try {
			Order order = new Order();
			order.setProduct(productRepository.findOne(1));
			order.setState(Boolean.FALSE);
			order = orderRepository.save(order);

			log.info("Saved Phone  id: " + order.getId());

		} catch (Exception e) {
			log.info(e.getStackTrace());
		}
	}
}