package com.judah.savetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.judah.savetravels.models.Expense;
import com.judah.savetravels.services.ExpenseService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	public final ExpenseService expenseServ;

	public ApiController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}
	
	// find all
	@GetMapping("/expenses")
	public List<Expense> findAllExpenses() {
		return expenseServ.getAll();
	}
	
	// create one
	@PostMapping("/expenses")
	public Expense createExpense(
			@RequestParam("name") String name,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") Integer amount,
			@RequestParam("description") String description) {
		Expense newExpense = new Expense(name, vendor, amount, description);
		return expenseServ.create(newExpense);
	}
	
	// find one
	@GetMapping("/expenses/{id}")
	public Expense findOneExpense(@PathVariable("id") Long id) {
		return expenseServ.findOne(id);
	}
	
	// edit
	@PutMapping("/expenses/{id}")
	public Expense findOneAndUpdate(
			@PathVariable("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("vendor") String vendor,
			@RequestParam("amount") Integer amount,
			@RequestParam("description") String description) {
		return expenseServ.update(id, name, vendor, amount, description);
	}
	
	// delete
	@DeleteMapping("/expenses/{id}")
	public String delete(@PathVariable("id") long id) {
		return expenseServ.deletebyId(id);
	}

}
