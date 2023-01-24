package com.judah.savetravels.controllers;

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

import com.judah.savetravels.models.Expense;
import com.judah.savetravels.services.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

	public final ExpenseService expenseServ;
	public ExpenseController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}
	
	@GetMapping("/all")
	public String allExpenses(Model model) {
		model.addAttribute("allExpenses", expenseServ.getAll());
		model.addAttribute("expense", new Expense());
		return "showAll.jsp";
	}
	
	@GetMapping("/one/{id}")
	public String oneExpense(@PathVariable("id") Long id, Model model) {
		Expense oneExpense = expenseServ.findOne(id);
		model.addAttribute("oneExpense", oneExpense);
		return "oneExpense.jsp";
	}
	
	@GetMapping("/new")
	public String newExpense(@ModelAttribute("expense") Expense expense) {
		return "newExpense.jsp";
	}
	
	@PostMapping("/all")
	public String proccessExpense(
			@Valid
			@ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allExpenses", expenseServ.getAll());
			return "showAll.jsp";
		}
		expenseServ.create(expense);
		return "redirect:/expenses/all";
	}
	
	@GetMapping("/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense expenseToBeEdited = expenseServ.findOne(id);
		model.addAttribute("expense", expenseToBeEdited);
		return "expenseEdit.jsp";
	}
	
	@PutMapping("/{id}")
	public String processEditExpense(
			@Valid
			@ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "expenseEdit.jsp";
		}
		expenseServ.update(expense);
		return "redirect:/expenses/all";
	}
	
	@DeleteMapping("/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		expenseServ.deletebyId(id);
		return "redirect:/expenses/all";
	}
	
}
