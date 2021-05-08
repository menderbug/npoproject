package nonprof.org.org.tiers.nonprofit.Controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import nonprof.org.org.tiers.nonprofit.Doman.Department;
//import nonprof.org.org.tiers.nonprofit.Doman.Donor;
import nonprof.org.org.tiers.nonprofit.Service.DepartmentService;
import java.util.List; 

@RestController
@RequestMapping("/department")
public class DepartmentController {
	private final DepartmentService departmentService; 
	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService; 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> departments = departmentService.findAllDepartments(); 
		return new ResponseEntity<>(departments, HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<List<Department>> getDepartmentByID(@PathVariable("id") String name) {
		List<Department> department = departmentService.findDepartmentByID(name); 
		return new ResponseEntity<>(department, HttpStatus.OK); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		Department updateDepartment = departmentService.updateDepartment(department); 
		return new ResponseEntity<>(updateDepartment, HttpStatus.OK); 
	}
}