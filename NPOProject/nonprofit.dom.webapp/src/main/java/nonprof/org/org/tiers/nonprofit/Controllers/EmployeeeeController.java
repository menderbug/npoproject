package nonprof.org.org.tiers.nonprofit.Controllers;

import org.springframework.http.*; 
import org.springframework.web.bind.annotation.*; 
import nonprof.org.org.tiers.nonprofit.Doman.Employeeee; 
import nonprof.org.org.tiers.nonprofit.Service.EmployeeeeService;
import java.util.List; 

@RestController
@RequestMapping("/employeeee")
public class EmployeeeeController {
	private final EmployeeeeService employeeService; 
	
	public EmployeeeeController(EmployeeeeService employeeService) {
		this.employeeService = employeeService; 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employeeee>> getAllEmployees() {
		List<Employeeee> employees = employeeService.findAllEmployee(); 
		return new ResponseEntity<>(employees, HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<List<Employeeee>> getEmployeeByID(@PathVariable("id") Long ID) {
		List<Employeeee> employee = employeeService.findEmployeeByID(ID); 
		return new ResponseEntity<>(employee, HttpStatus.OK); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employeeee> updateEmployee(@RequestBody Employeeee employee) {
		Employeeee updateEmployee = employeeService.updateEmployees(employee); 
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK); 
	}
}