package com.judah.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.judah.dojosandninjas.models.Dojo;
import com.judah.dojosandninjas.models.Ninja;
import com.judah.dojosandninjas.services.DojoNinjaServ;

@Controller
@RequestMapping("ninjas")
public class NinjaApiController {
	
	private final DojoNinjaServ dojoNinjaServ;
	public NinjaApiController(DojoNinjaServ dojoNinjaServ) {
		this.dojoNinjaServ = dojoNinjaServ;
	}
	
	@GetMapping("/new")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojo = dojoNinjaServ.allDojos();
		model.addAttribute("dojos", allDojo);
		return "/DojosAndNinjas/addNinja.jsp";
	}
	
	@PostMapping("/new")
	public String processNinja(
			@Valid
			@ModelAttribute("ninja") Ninja ninja, Model model, BindingResult result) {
		if(result.hasErrors()) {
			List<Dojo> allDojo = dojoNinjaServ.allDojos();
			model.addAttribute("dojos", allDojo);
			return "/DojosAndNinjas/addNinja.jsp";
		} else {
			dojoNinjaServ.addNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
}
