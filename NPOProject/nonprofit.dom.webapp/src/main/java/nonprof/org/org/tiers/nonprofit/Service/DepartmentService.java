package nonprof.org.org.tiers.nonprofit.Service;

import org.springframework.stereotype.*;
import nonprof.org.org.tiers.nonprofit.Doman.Department;
import nonprof.org.org.tiers.nonprofit.Repo.DepartmentRepo;
import java.util.List; 
import javax.transaction.Transactional; 

@Service
@Transactional
public class DepartmentService {
	private final DepartmentRepo departmentRepo; 
	
	public DepartmentService(DepartmentRepo departmentRepo) {
		this.departmentRepo = departmentRepo; 
	}
	
	public List<Department> findAllDepartments() {
		return departmentRepo.findAll(); 
	}
	
	public Department updateDepartment(Department department) {
		return departmentRepo.save(department); 
	}
	
	public List<Department> findDepartmentByID(String name) {
		return departmentRepo.findDepartmentByID(name); 
	}
}