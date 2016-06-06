package com.soin.labs;

import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.soin.labs.domains.Internet;
import com.soin.labs.repositories.InternetRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoSoinWebApplication.class)
@WebAppConfiguration
public class InternetTest {

	private InternetRepository internetRepository;
	private Logger log = Logger.getLogger(InternetTest.class);
	Random randomGenerator = new Random();

	@Autowired
	public void setInternetRepository(InternetRepository productRepository) {
		this.internetRepository = productRepository;
	}

	/**
	 * This test verify the save internet method in the Internet Repository
	 */
	@Test
	public void createProduct() {

		try {
			Internet internet = new Internet();
			internet.setDescription("internet -" + randomGenerator.nextInt());
			internet.setVelocity(2);
			internet = internetRepository.save(internet);

			log.info("Saved Internet  id: " + internet.getId());

		} catch (Exception e) {
			log.info(e.getStackTrace());
		}
	}
}