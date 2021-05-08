package nonprof.org.org.tiers.nonprofit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import nonprof.org.org.tiers.nonprofit.Doman.Department;

public interface DepartmentRepo extends JpaRepository<Department, String> {
	List<Department> findDepartmentByID(String name);
}