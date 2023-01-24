package com.judah.bookclub.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.judah.bookclub.services.BookService;
import com.judah.bookclub.services.UserService;

@Controller
public class MainController {

	private final BookService bookServ;
	private final UserService userServ;
	public MainController(UserService userServ, BookService bookServ) {
		this.userServ = userServ;
		this.bookServ = bookServ;
	}

	@GetMapping("/books")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/register";
		}
		model.addAttribute("allBooks", bookServ.getAll());
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "main/dashboard.jsp";
	}
}