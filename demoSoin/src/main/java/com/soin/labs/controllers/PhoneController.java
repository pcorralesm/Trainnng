package com.soin.labs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soin.labs.application.services.impl.PhoneBusinessServiceImpl;
import com.soin.labs.domains.Phone;

@Controller
public class PhoneController {

	private PhoneBusinessServiceImpl phoneBusinessService;

	@Autowired
	@Qualifier("phoneBean")
	public void setPhoneBusinessService(PhoneBusinessServiceImpl phoneService) {
		this.phoneBusinessService = phoneService;
	}

	@RequestMapping(value = "/phones", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("phones", phoneBusinessService.listAll());
		System.out.println("Returning rpoducts:");
		return "phones";
	}

	@RequestMapping("phone/{id}")
	public String showPhone(@PathVariable Integer id, Model model) {
		model.addAttribute("phone", phoneBusinessService.getById(id));
		return "phoneshow";
	}

	@RequestMapping("phone/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("phone", phoneBusinessService.getById(id));
		return "phoneform";
	}

	@RequestMapping("phone/new")
	public String newPhone(Model model) {
		model.addAttribute("phone", new Phone());
		return "phoneform";
	}

	@RequestMapping(value = "phone", method = RequestMethod.POST)
	public String savePhone(Phone phone) {
		phone = phoneBusinessService.save(phone);
		return "redirect:/phone/" + phone.getId();
	}

}
