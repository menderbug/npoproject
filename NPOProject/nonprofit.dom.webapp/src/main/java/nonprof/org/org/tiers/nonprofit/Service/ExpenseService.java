package nonprof.org.org.tiers.nonprofit.Service;

import org.springframework.stereotype.*;
import nonprof.org.org.tiers.nonprofit.Doman.Expense;
import nonprof.org.org.tiers.nonprofit.Repo.ExpenseRepo;
import java.util.List; 
import javax.transaction.Transactional; 

@Service
@Transactional
public class ExpenseService {
	private final ExpenseRepo expenseRepo; 
	
	public ExpenseService(ExpenseRepo expenseRepo) {
		this.expenseRepo = expenseRepo; 
	}
	
	public List<Expense> findAllExpenses() {
		return expenseRepo.findAll(); 
	}
	
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense); 
	}
	
	public List<Expense> findExpenseByID(Long ID) {
		return expenseRepo.findExpenseByID(ID); 
	}
}