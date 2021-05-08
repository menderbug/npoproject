package nonprof.org.org.tiers.nonprofit.Controllers;

import org.springframework.http.*; 
import org.springframework.web.bind.annotation.*;
import nonprof.org.org.tiers.nonprofit.Doman.Expense; 
import nonprof.org.org.tiers.nonprofit.Service.ExpenseService; 
import java.util.List; 

@RestController
@RequestMapping("/expense")
public class ExpenseController {
	private final ExpenseService expenseService; 
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService; 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Expense>> getAllExpenses() {
		List<Expense> expenses = expenseService.findAllExpenses(); 
		return new ResponseEntity<>(expenses, HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<List<Expense>> getExpenseByID(@PathVariable("id") Long ID) {
		List<Expense> expense = expenseService.findExpenseByID(ID); 
		return new ResponseEntity<>(expense, HttpStatus.OK); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense) {
		Expense updateExpense = expenseService.updateExpense(expense); 
		return new ResponseEntity<>(updateExpense, HttpStatus.OK); 
	}
}