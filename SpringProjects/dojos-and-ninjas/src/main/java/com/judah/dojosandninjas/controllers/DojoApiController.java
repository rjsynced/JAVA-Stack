package com.judah.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.judah.dojosandninjas.models.Dojo;
import com.judah.dojosandninjas.services.DojoNinjaServ;

@Controller
@RequestMapping("dojos")
public class DojoApiController {
	private final DojoNinjaServ dojoNinjaServ;

	public DojoApiController(DojoNinjaServ dojoNinjaServ) {
		this.dojoNinjaServ = dojoNinjaServ;
	}
	
	@GetMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/DojosAndNinjas/addDojo.jsp";
	}
	
	@PostMapping("/new")
	public String processDojo(
			@Valid
			@ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/DojosAndNinjas/addDojo.jsp";
		} else {
			dojoNinjaServ.addDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/{dojoId}")
	public String showDojo(@PathVariable("dojoId") Long id, Model model) {
		Dojo dojo = dojoNinjaServ.oneDojo(id);
		model.addAttribute("dojo", dojo);
		return "/DojosAndNinjas/list.jsp";
	}

}
