package com.soin.labs.utils;

import org.apache.log4j.Logger;

import com.soin.labs.domains.Order;

/**
 * This class is a implementation for Runnable interface, the idea is create a
 * thread the process the order
 * 
 * @author Paula Maria Corrales M
 */
public class ThreadProcessOrder implements Runnable {

	private Order order;
	private Logger log = Logger.getLogger(ThreadProcessOrder.class);
	private final static int SECONDS = 2;

	public ThreadProcessOrder(Order order) {
		this.order = order;
	}

	/**
	 * This method simulate the order need to execute a process
	 */
	@Override
	public void run() {
		
		log.info(" start Execute the process:  " + "order id " + order.getId());
		
		//wait some seconds for other process
		try {
			Thread.sleep(SECONDS * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		catch (Exception ex) {
			log.error("Exception" + ex.getMessage());

		} finally {
			log.info("proccess the order: " + order.getId());
		}
		
	}
}