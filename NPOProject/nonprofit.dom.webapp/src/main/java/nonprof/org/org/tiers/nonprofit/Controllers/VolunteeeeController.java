package nonprof.org.org.tiers.nonprofit.Controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import nonprof.org.org.tiers.nonprofit.Doman.Volunteeee; 
import nonprof.org.org.tiers.nonprofit.Service.VolunteeeeService;
import java.util.List; 

@RestController
@RequestMapping("/volunteeee")
public class VolunteeeeController {
	private final VolunteeeeService volunteerService; 
	
	public VolunteeeeController(VolunteeeeService volunteerService) {
		this.volunteerService = volunteerService; 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Volunteeee>> getAllVolunteers() {
		List<Volunteeee> volunteers = volunteerService.findAllVolunteer(); 
		return new ResponseEntity<>(volunteers, HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<List<Volunteeee>> getVolunteerByID(@PathVariable("id") Long ID) {
		List<Volunteeee> volunteer = volunteerService.findVolunteerByID(ID); 
		return new ResponseEntity<>(volunteer, HttpStatus.OK); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Volunteeee> updateVolunteer(@RequestBody Volunteeee volunteer) {
		Volunteeee updateVolunteer = volunteerService.updateVolunteers(volunteer); 
		return new ResponseEntity<>(updateVolunteer, HttpStatus.OK); 
	}
}