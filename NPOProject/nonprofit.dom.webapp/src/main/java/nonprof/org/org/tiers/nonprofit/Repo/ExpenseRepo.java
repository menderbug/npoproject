package nonprof.org.org.tiers.nonprofit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import nonprof.org.org.tiers.nonprofit.Doman.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
	List<Expense> findExpenseByID(Long ID);
}