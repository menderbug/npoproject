package nonprof.org.org.tiers.nonprofit.Service;

import org.springframework.stereotype.*;
import nonprof.org.org.tiers.nonprofit.Doman.Volunteer;
import nonprof.org.org.tiers.nonprofit.Repo.VolunteeRepo;
import java.util.List; 
import javax.transaction.Transactional; 

@Service
@Transactional
public class VolunteerService {
	private final VolunteeRepo volunteeRepo; 
	
	public VolunteerService(VolunteeRepo volunteeRepo) {
		this.volunteeRepo = volunteeRepo; 
	}
	
	public List<Volunteer> findAllVolunteers() {
		return this.volunteeRepo.findAll(); 
	}
	
	public Volunteer updateVolunteer(Volunteer volunteer) {
		return this.volunteeRepo.save(volunteer); 
	}
	
	public List<Volunteer> findVolunteerByID(Long ID) {
		return this.volunteeRepo.findVolunteerByID(ID); 
	}
}