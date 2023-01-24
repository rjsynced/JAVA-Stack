package com.judah.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.judah.savetravels.models.Expense;
import com.judah.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepo;
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	public Expense create(Expense expense) {
		return expenseRepo.save(expense);
	}

	public List<Expense> getAll() {
		return expenseRepo.findAll();
	}
	
	public Expense findOne(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	public Expense update(Long id, String name, String vendor, Integer amount, String description) {
		Expense expenseToBeUpdated = new Expense(id, name, vendor, amount, description);
		return expenseRepo.save(expenseToBeUpdated);
	}
	
	public Expense update(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public String deletebyId(Long id) {
		expenseRepo.deleteById(id);
		return "you deleted the record with the id of: " + id;
	}
	
}
