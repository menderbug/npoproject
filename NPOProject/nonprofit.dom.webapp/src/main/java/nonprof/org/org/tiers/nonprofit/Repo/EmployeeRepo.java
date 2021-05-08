package nonprof.org.org.tiers.nonprofit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import nonprof.org.org.tiers.nonprofit.Doman.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	List<Employee> findEmployeeByID(Long ID);
}