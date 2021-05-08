package nonprof.org.org.tiers.nonprofit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; 
import nonprof.org.org.tiers.nonprofit.Doman.Employeeee;

public interface EmployeeeeRep extends JpaRepository<Employeeee, Long> {
	List<Employeeee> findEmployeeeeByID(Long ID);
}