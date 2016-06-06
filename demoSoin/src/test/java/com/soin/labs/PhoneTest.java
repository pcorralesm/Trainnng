package com.soin.labs;

import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.soin.labs.domains.Phone;
import com.soin.labs.repositories.PhoneRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoSoinWebApplication.class)
@WebAppConfiguration
public class PhoneTest {

	private PhoneRepository phoneRepository;
	private Logger log = Logger.getLogger(PhoneTest.class);
	Random randomGenerator = new Random();

	@Autowired
	public void setPhoneRepository(PhoneRepository productRepository) {
		this.phoneRepository = productRepository;
	}

	/**
	 * This test verify the save phone method in the Phone Repository
	 */
	@Test
	public void createProduct() {

		try {
			Phone phone = new Phone();
			phone.setDescription("mobile -" + randomGenerator.nextInt());
			phone.setModel("Iphone" + randomGenerator.nextInt());
			phone = phoneRepository.save(phone);

			log.info("Saved Phone  id: " + phone.getId());

		} catch (Exception e) {
			log.info(e.getStackTrace());
		}
	}
}