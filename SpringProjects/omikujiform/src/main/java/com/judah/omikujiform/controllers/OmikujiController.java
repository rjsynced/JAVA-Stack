package com.judah.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		return "form.jsp";
	}
	
	@GetMapping("/results")
	public String displayResults(Model model) {
		return "index.jsp";
	}
	
	@PostMapping("/omikuji/process")
	public String processForm(
			@RequestParam("number") String number,
			@RequestParam("city") String city,
			@RequestParam("name") String name,
			@RequestParam("hobby") String hobby,
			@RequestParam("thing") String thing,
			@RequestParam("message") String message, HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("message", message);
		return "redirect:/results";
	}
}
