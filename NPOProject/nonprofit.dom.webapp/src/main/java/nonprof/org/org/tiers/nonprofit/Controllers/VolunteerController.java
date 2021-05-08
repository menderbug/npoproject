package nonprof.org.org.tiers.nonprofit.Controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import nonprof.org.org.tiers.nonprofit.Doman.Volunteer; 
import nonprof.org.org.tiers.nonprofit.Service.VolunteerService;
import java.util.List; 

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {
	private final VolunteerService volunteerService; 
	
	public VolunteerController(VolunteerService volunteerService) {
		this.volunteerService = volunteerService; 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Volunteer>> getAllVolunteers() {
		List<Volunteer> volunteers = volunteerService.findAllVolunteers(); 
		return new ResponseEntity<>(volunteers, HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<List<Volunteer>> getVolunteerByID(@PathVariable("id") Long ID) {
		List<Volunteer> volunteer = volunteerService.findVolunteerByID(ID); 
		return new ResponseEntity<>(volunteer, HttpStatus.OK); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Volunteer> updateVolunteer(@RequestBody Volunteer volunteer) {
		Volunteer updateVolunteer = volunteerService.updateVolunteer(volunteer); 
		return new ResponseEntity<>(updateVolunteer, HttpStatus.OK); 
	}
}