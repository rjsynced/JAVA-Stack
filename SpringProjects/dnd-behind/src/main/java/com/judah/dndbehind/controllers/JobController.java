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

import com.judah.dndbehind.services.JobService;
import com.judah.dndbehind.services.UserService;
import com.judah.dndbehind.models.Job;

@Controller
@RequestMapping("/classes")
public class JobController {

	private final JobService jobServ;
	private final UserService userServ;

	public JobController(JobService jobServ, UserService userServ) {
		this.jobServ = jobServ;
		this.userServ = userServ;
	}

	@GetMapping("/create")
	public String createJob(@ModelAttribute("class") Job job, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/campaigns";
		}
		return "class/newClass.jsp";
	}

	@PostMapping("/create")
	public String processCreateJob(@Valid @ModelAttribute("class") Job job, BindingResult result) {
		if (result.hasErrors()) {
			return "class/newClass.jsp";
		}
		jobServ.create(job);
		return "redirect:/campaigns";
	}

	@GetMapping("/edit/{id}")
	public String editJob(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/campaigns";
		}
		Job job = jobServ.getOne(id);
		model.addAttribute("job", job);
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "job/editClass.jsp";
	}

	@PutMapping("/edit/{id}")
	public String processEditJob(@PathVariable("id") Long id, @Valid @ModelAttribute("job") Job job,
			BindingResult result) {
		if (result.hasErrors()) {
			return "job/editJob.jsp";
		}
		jobServ.update(job);
		return "redirect:/campaigns";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteJob(@PathVariable("id") Long id) {
		System.out.println("got here");
		jobServ.deleteById(id);
		return "redirect:/campaigns";
	}

	@GetMapping("/view/{id}")
	public String viewJob(@PathVariable("id") Long id, Model model, HttpSession session) {
		Job job = jobServ.getOne(id);
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		model.addAttribute("job", job);
		return "job/viewClass.jsp";
	}
}