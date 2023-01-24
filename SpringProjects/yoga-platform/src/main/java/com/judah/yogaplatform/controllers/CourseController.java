package com.judah.yogaplatform.controllers;

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

import com.judah.yogaplatform.models.Course;
import com.judah.yogaplatform.services.CourseService;
import com.judah.yogaplatform.services.UserService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private final CourseService courseServ;
	private final UserService userServ;
	public CourseController(CourseService courseServ, UserService userServ) {
		this.courseServ = courseServ;
		this.userServ = userServ;
	}
	
	@GetMapping("/create")
	public String createCourse(
			@ModelAttribute("course") Course course, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/courses";
		}
		return "course/newCourse.jsp";
	}
	
	@PostMapping("/create")
	public String processCreateCourse(
			@Valid
			@ModelAttribute("course") Course course, BindingResult result) {
		if(result.hasErrors()) {
			return "course/newCourse.jsp";
		}
		courseServ.create(course);
		return "redirect:/courses";
	}
	
	@GetMapping("/edit/{id}")
	public String editCourse(
			@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/courses";
		}
		Course course = courseServ.getOne(id);
		model.addAttribute("course", course);
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "course/editCourse.jsp";
	}
	
	
	@PutMapping("/edit/{id}")
	public String processEditCourse(
			@PathVariable("id") Long id, 
			@Valid
			@ModelAttribute("course") Course course, BindingResult result) {
		if(result.hasErrors()) {
			return "course/editCourse.jsp";
		}
		courseServ.update(course);
		return "redirect:/courses";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCourse(
			@PathVariable("id") Long id) {
		courseServ.deleteById(id);
		return "redirect:/courses";
	}
	
	@GetMapping("/view/{id}")
	public String viewCourse(
			@PathVariable("id") Long id, Model model, HttpSession session) {
		Course course = courseServ.getOne(id);
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		model.addAttribute("course", course);
		return "course/viewCourse.jsp";
	}

}
