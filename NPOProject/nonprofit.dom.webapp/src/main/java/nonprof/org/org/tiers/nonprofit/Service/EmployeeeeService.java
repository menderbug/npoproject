package nonprof.org.org.tiers.nonprofit.Service;

import org.springframework.stereotype.*;
import nonprof.org.org.tiers.nonprofit.Doman.Employeeee;
import nonprof.org.org.tiers.nonprofit.Repo.EmployeeeeRep;
import java.util.List; 
import javax.transaction.Transactional; 

@Service
@Transactional
public class EmployeeeeService {
	private final EmployeeeeRep employeeRepo; 
	
	public EmployeeeeService(EmployeeeeRep employeeRepo) {
		this.employeeRepo = employeeRepo; 
	} 
	
	public List<Employeeee> findAllEmployee() {
		return employeeRepo.findAll(); 
	}
	
	public Employeeee updateEmployees(Employeeee employee) {
		return employeeRepo.save(employee); 
	}
	
	public List<Employeeee> findEmployeeByID(Long ID) {
		return employeeRepo.findEmployeeeeByID(ID); 
	}
}