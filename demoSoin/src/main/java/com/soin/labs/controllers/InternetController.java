package com.soin.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soin.labs.application.services.impl.InternetBusinessServiceImpl;
import com.soin.labs.domains.Internet;

@Controller
public class InternetController {

	private InternetBusinessServiceImpl internetService;

	@Autowired
	@Qualifier("internetBean")
	public void setInternetBusinessService(InternetBusinessServiceImpl internetService) {
		this.internetService = internetService;
	}

	@RequestMapping(value = "/internets", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("internets", internetService.listAll());
		System.out.println("Returning rpoducts:");
		return "internets";
	}

	@RequestMapping("internet/{id}")
	public String showInternet(@PathVariable Integer id, Model model) {
		model.addAttribute("internet", internetService.getById(id));
		return "internetshow";
	}

	@RequestMapping("internet/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("internet", internetService.getById(id));
		return "internetform";
	}

	@RequestMapping("internet/new")
	public String newInternet(Model model) {
		model.addAttribute("internet", new Internet());
		return "internetform";
	}

	@RequestMapping(value = "internet", method = RequestMethod.POST)
	public String saveInternet(Internet internet) {
		internet = internetService.save(internet);
		return "redirect:/internet/" + internet.getId();
	}
}
