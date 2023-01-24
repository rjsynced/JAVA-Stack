package com.judah.bookclub.controllers;

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

import com.judah.bookclub.models.Book;
import com.judah.bookclub.services.BookService;
import com.judah.bookclub.services.UserService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	private final BookService bookServ;
	private final UserService userServ;
	public BookController(BookService bookServ, UserService userServ) {
		this.bookServ = bookServ;
		this.userServ = userServ;
	}
	
	@GetMapping("/create")
	public String createBook(
			@ModelAttribute("book") Book book, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/books";
		}
		return "book/newBook.jsp";
	}
	
	@PostMapping("/create")
	public String processCreateBook(
			@Valid
			@ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "book/newBook.jsp";
		}
		bookServ.create(book);
		return "redirect:/books";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(
			@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/books";
		}
		Book book = bookServ.getOne(id);
		model.addAttribute("book", book);
		return "book/editBook.jsp";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(
			@PathVariable("id") Long id) {
		bookServ.delete(id);
		return "redirect:/books";
	}
	
	@PutMapping("/edit/{id}")
	public String processEditBook(
			@PathVariable("id") Long id, 
			@Valid
			@ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "book/editBook.jsp";
		}
		bookServ.update(book);
		return "redirect:/books";
	}
	
	@GetMapping("/view/{id}")
	public String viewBook(
			@PathVariable("id") Long id, Model model, HttpSession session) {
		Book book = bookServ.getOne(id);
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		model.addAttribute("book", book);
		return "book/viewBook.jsp";
	}

}
