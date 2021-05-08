package nonprof.org.org.tiers.nonprofit.Controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import nonprof.org.org.tiers.nonprofit.Doman.Employee;
import nonprof.org.org.tiers.nonprofit.Service.EmployeeService;
import java.util.List; 

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService employeeService; 
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService; 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.findAllEmployees(); 
		return new ResponseEntity<>(employees, HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<List<Employee>> getEmployeeByID(@PathVariable("id") Long ID) {
		List<Employee> employee = employeeService.findEmployeeByID(ID); 
		return new ResponseEntity<>(employee, HttpStatus.OK); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updateEmployee = employeeService.updateEmployee(employee); 
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK); 
	}
}