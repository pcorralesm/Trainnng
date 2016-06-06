package com.soin.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soin.labs.application.services.impl.ProductBusinessServiceImpl;
import com.soin.labs.domains.Product;

@Controller
public class ProductController {

	private ProductBusinessServiceImpl productBusinessService;

	@Autowired
	@Qualifier("productBean")
	public void setProductBusinessService(ProductBusinessServiceImpl productService) {
		this.productBusinessService = productService;
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("products", productBusinessService.listAll());
		System.out.println("Returning rpoducts:");
		return "products";
	}

	@RequestMapping("product/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productBusinessService.getById(id));
		return "productshow";
	}

	@RequestMapping("product/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productBusinessService.getById(id));
		return "productform";
	}

	@RequestMapping("product/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productform";
	}

	@RequestMapping(value = "product", method = RequestMethod.POST)
	public String saveProduct(Product product) {
		product = productBusinessService.save(product);
		return "redirect:/product/" + product.getId();
	}

}
