package nonprof.org.org.tiers.nonprofit.Service;

import org.springframework.stereotype.*; 
import nonprof.org.org.tiers.nonprofit.Doman.Volunteeee; 
import nonprof.org.org.tiers.nonprofit.Repo.VolunteeeeRep; 
import java.util.List; 
import javax.transaction.Transactional; 

@Service
@Transactional
public class VolunteeeeService {
	private final VolunteeeeRep volunteeRepos; 
	
	public VolunteeeeService(VolunteeeeRep volunteeRepos) {
		this.volunteeRepos = volunteeRepos; 
	}
	
	public List<Volunteeee> findAllVolunteer() {
		return this.volunteeRepos.findAll(); 
	}
	
	public Volunteeee updateVolunteers(Volunteeee volunteer) {
		return this.volunteeRepos.save(volunteer); 
	}
	
	public List<Volunteeee> findVolunteerByID(Long ID) {
		return this.volunteeRepos.findVolunteeeeByID(ID); 
	}
}