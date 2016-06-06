package com.soin.labs;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoSoinWebApplication.class)
@WebAppConfiguration
public class DemoSoinApplicationTests {

	private Logger log = Logger.getLogger(DemoSoinApplicationTests.class);

	@Test
	public void contextLoads() {
		log.info("Context is Ok");
	}
}
