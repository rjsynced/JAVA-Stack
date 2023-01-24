package com.judah.yogaplatform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.judah.yogaplatform.services.CourseService;
import com.judah.yogaplatform.services.UserService;

@Controller
public class MainController {

	private final CourseService courseServ;
	private final UserService userServ;
	public MainController(UserService userServ, CourseService courseServ) {
		this.userServ = userServ;
		this.courseServ = courseServ;
	}

	@GetMapping("/courses")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/register";
		}
		model.addAttribute("allCourses", courseServ.getAll());
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "main/dashboard.jsp";
	}
}
