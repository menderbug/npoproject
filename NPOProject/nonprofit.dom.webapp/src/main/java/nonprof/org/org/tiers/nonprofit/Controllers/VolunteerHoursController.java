package nonprof.org.org.tiers.nonprofit.Controllers; 

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import nonprof.org.org.tiers.nonprofit.Doman.VolunteerHours; 
import nonprof.org.org.tiers.nonprofit.Service.VolunteerHourService;
import java.util.List; 

@RestController
@RequestMapping("/volunteerhours")
public class VolunteerHoursController {
	private final VolunteerHourService volunteerService; 
	
	public VolunteerHoursController(VolunteerHourService volunteerService) {
		this.volunteerService = volunteerService; 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<VolunteerHours>> getAllVolunteerHours() {
		List<VolunteerHours> volunteerHours = volunteerService.findAllVolunteerHours(); 
		return new ResponseEntity<>(volunteerHours, HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<List<VolunteerHours>> getVolunteerHoursByID(@PathVariable(
			"id") Long ID) {
		List<VolunteerHours> volunteerHour = volunteerService.findVolunteerHoursByID(ID); 
		return new ResponseEntity<>(volunteerHour, HttpStatus.OK); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<VolunteerHours> updateVolunteerHours(@RequestBody 
			VolunteerHours volunteer) {
		VolunteerHours updateVolunteerhour = volunteerService.updateVolunteerHour(volunteer); 
		return new ResponseEntity<>(updateVolunteerhour, HttpStatus.OK); 
	}
}