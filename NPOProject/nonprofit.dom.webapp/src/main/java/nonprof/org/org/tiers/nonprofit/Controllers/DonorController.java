package nonprof.org.org.tiers.nonprofit.Controllers;

import org.springframework.http.*; 
import org.springframework.web.bind.annotation.*;
import nonprof.org.org.tiers.nonprofit.Doman.Donor;
//import nonprof.org.org.tiers.nonprofit.Doman.Nonprofit;
import nonprof.org.org.tiers.nonprofit.Service.DonorService;
import java.util.List; 

@RestController
@RequestMapping("/donor")
public class DonorController {
	private final DonorService donorService; 
	
	public DonorController(DonorService donorService) {
		this.donorService = donorService; 
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Donor>> getAllDonors() {
		List<Donor> donors = donorService.findAllDonors(); 
		return new ResponseEntity<>(donors, HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<List<Donor>> getDonorByID(@PathVariable("id") Long id) {
		List<Donor> donor = donorService.findDonorByID(id); 
		return new ResponseEntity<>(donor, HttpStatus.OK); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Donor> updateDonor(@RequestBody Donor donor) {
		Donor updateDonor = donorService.updateDonor(donor); 
		return new ResponseEntity<>(updateDonor, HttpStatus.OK); 
	}
}