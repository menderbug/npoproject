package nonprof.org.org.tiers.nonprofit.Service;

import org.springframework.stereotype.*;
import nonprof.org.org.tiers.nonprofit.Doman.Employee;
import nonprof.org.org.tiers.nonprofit.Repo.EmployeeRepo;
import java.util.List; 
import javax.transaction.Transactional; 

@Service
@Transactional
public class EmployeeService {
	private final EmployeeRepo employeeRepo; 
	
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo; 
	}
	
	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll(); 
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee); 
	}
	
	public List<Employee> findEmployeeByID(Long ID) {
		return employeeRepo.findEmployeeByID(ID); 
	}
}