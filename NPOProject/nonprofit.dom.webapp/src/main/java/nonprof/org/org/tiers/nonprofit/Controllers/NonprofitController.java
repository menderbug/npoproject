package nonprof.org.org.tiers.nonprofit.Controllers;

import org.springframework.http.*;
import org.springframework.web.*;
import nonprof.org.org.tiers.nonprofit.Doman.Nonprofit; 
import nonprof.org.org.tiers.nonprofit.Service.NonprofitService;
import java.util.List; 
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nonprofit")
public class NonprofitController {
	private final NonprofitService nonprofitService; 
	
	public NonprofitController(NonprofitService nonprofitService) {
		this.nonprofitService = nonprofitService; 
	} 
	
	@GetMapping("/all")
	public ResponseEntity<List<Nonprofit>> getAllNonprofits() {
		List<Nonprofit> nonprofits = nonprofitService.findAllNonprofits(); 
		return new ResponseEntity<>(nonprofits, HttpStatus.OK); 
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<List<Nonprofit>> getNonprofitByID(@PathVariable("id") Long id) {
		List<Nonprofit> nonprofit = nonprofitService.findNonprofitByID(id); 
		return new ResponseEntity<>(nonprofit, HttpStatus.OK); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Nonprofit> updateNonprofit(@RequestBody Nonprofit nonprofit) {
		Nonprofit updateNonprofit = nonprofitService.updateNonprofit(nonprofit); 
		return new ResponseEntity<>(updateNonprofit, HttpStatus.OK); 
	}
}