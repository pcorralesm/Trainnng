package com.soin.labs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soin.labs.application.services.impl.OrderBusinessServiceImpl;
import com.soin.labs.application.services.impl.ProductBusinessServiceImpl;
import com.soin.labs.domains.Order;
import com.soin.labs.domains.Product;

@Controller
public class OrderController {

	private OrderBusinessServiceImpl orderBussinessService;
	private ProductBusinessServiceImpl productBusinessService;

	@Autowired
	@Qualifier("orderBean")
	public void setOrderBussinessService(OrderBusinessServiceImpl orderService) {
		this.orderBussinessService = orderService;
	}

	@Autowired
	@Qualifier("productBean")
	public void setProductBusinessService(ProductBusinessServiceImpl productService) {
		this.productBusinessService = productService;
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("orders", orderBussinessService.listAll());
		System.out.println("Returning orders:");
		return "orders";
	}

	@RequestMapping("order/{id}")
	public String showOrder(@PathVariable Integer id, Model model) {
		model.addAttribute("order", orderBussinessService.getById(id));
		return "ordershow";
	}

	@RequestMapping("order/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("order", orderBussinessService.getById(id));
		return "orderform";
	}

	@RequestMapping("order/new")
	public String newOrder(Model model) {
		model.addAttribute("order", new Order());
		model.addAttribute("products", productBusinessService.listAll());
		return "orderform";
	}

	@RequestMapping(value = "order", method = RequestMethod.POST)
	public String saveOrder(Order Order) {

		orderBussinessService.save(Order);
		return "redirect:/orders/";
	}

	@ModelAttribute("products")
	public List<Product> getProducts() {
		return (List<Product>) productBusinessService.listAll();
	}

}