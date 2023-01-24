package com.judah.dndbehind.controllers;

import java.util.List;

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

import com.judah.dndbehind.models.Character;
import com.judah.dndbehind.models.Job;
import com.judah.dndbehind.models.Race;
import com.judah.dndbehind.services.CharacterService;
import com.judah.dndbehind.services.JobService;
import com.judah.dndbehind.services.RaceService;
import com.judah.dndbehind.services.UserService;

@Controller
@RequestMapping("/characters")
public class CharacterController {

	private final CharacterService characterServ;
	private final UserService userServ;
	private final RaceService raceServ;
	private final JobService jobServ;

	public CharacterController(CharacterService characterServ, UserService userServ, RaceService raceServ,
			JobService jobServ) {
		this.characterServ = characterServ;
		this.userServ = userServ;
		this.jobServ = jobServ;
		this.raceServ = raceServ;
	}

	@GetMapping("/create")
	public String createCharacter(@ModelAttribute("character") Character character, HttpSession session, Model model) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/campaigWns";
		}
		List<Race> allRace = raceServ.getAll();
		model.addAttribute("races", allRace);
		List<Job> allJob = jobServ.getAll();
		model.addAttribute("jobs", allJob);
		return "character/newCharacter.jsp";
	}

	@PostMapping("/create")
	public String processCreateCharacter(@Valid @ModelAttribute("character") Character character, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			List<Race> allRace = raceServ.getAll();
			model.addAttribute("races", allRace);
			List<Job> allJob = jobServ.getAll();
			model.addAttribute("jobs", allJob);
			return "character/newCharacter.jsp";
		}
		characterServ.create(character);
		return "redirect:/campaigns";
	}

	@GetMapping("/edit/{id}")
	public String editCharacter(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/campaigns";
		}
		List<Race> allRace = raceServ.getAll();
		model.addAttribute("races", allRace);
		List<Job> allJob = jobServ.getAll();
		model.addAttribute("jobs", allJob);
		Character character = characterServ.getOne(id);
		model.addAttribute("character", character);
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "character/editCharacter.jsp";
	}

	@PutMapping("/edit/{id}")
	public String processEditCharacter(@PathVariable("id") Long id,
			@Valid @ModelAttribute("character") Character character, BindingResult result) {
		if (result.hasErrors()) {
			return "character/editCharacter.jsp";
		}
		characterServ.update(character);
		return "redirect:/campaigns";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCharacter(@PathVariable("id") Long id) {
		System.out.println("got here");
		characterServ.deleteById(id);
		return "redirect:/campaigns";
	}

	@GetMapping("/view/{id}")
	public String viewCharacter(@PathVariable("id") Long id, Model model, HttpSession session) {
		Character character = characterServ.getOne(id);
		model.addAttribute("user", userServ.getUser(id));
		model.addAttribute("oneJob", jobServ.getOne(id));
		model.addAttribute("oneRace", raceServ.getOne(id));
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		model.addAttribute("character", character);
		return "character/viewCharacter.jsp";
	}
}