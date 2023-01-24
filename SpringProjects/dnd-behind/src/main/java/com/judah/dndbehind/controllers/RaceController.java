package com.judah.dndbehind.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.judah.dndbehind.services.RaceService;
import com.judah.dndbehind.services.UserService;
import com.judah.dndbehind.models.Race;

@Controller
@RequestMapping("/races")
public class RaceController {

	private final RaceService raceServ;
	private final UserService userServ;

	public RaceController(RaceService raceServ, UserService userServ) {
		this.raceServ = raceServ;
		this.userServ = userServ;
	}

	@GetMapping("/create")
	public String createRace(@ModelAttribute("race") Race race, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/campaigns";
		}
		return "race/newRace.jsp";
	}

	@PostMapping("/create")
	public String processCreateRace(@Valid @ModelAttribute("race") Race race, BindingResult result) {
		if (result.hasErrors()) {
			return "race/newRace.jsp";
		}
		raceServ.create(race);
		return "redirect:/campaigns";
	}

	@GetMapping("/edit/{id}")
	public String editRace(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/campaigns";
		}
		Race race = raceServ.getOne(id);
		model.addAttribute("race", race);
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "race/editRace.jsp";
	}

	@PutMapping("/edit/{id}")
	public String processEditRace(@PathVariable("id") Long id, @Valid @ModelAttribute("race") Race race,
			BindingResult result) {
		if (result.hasErrors()) {
			return "race/editRace.jsp";
		}
		raceServ.update(race);
		return "redirect:/campaigns";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteRace(@PathVariable("id") Long id) {
		System.out.println("got here");
		raceServ.deleteById(id);
		return "redirect:/campaigns";
	}

	@GetMapping("/view/{id}")
	public String viewRace(@PathVariable("id") Long id, Model model, HttpSession session) {
		Race race = raceServ.getOne(id);
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		model.addAttribute("race", race);
		return "race/viewRace.jsp";
	}
}