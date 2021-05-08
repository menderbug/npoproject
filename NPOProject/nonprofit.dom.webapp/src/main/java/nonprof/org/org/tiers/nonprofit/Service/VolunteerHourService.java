package nonprof.org.org.tiers.nonprofit.Service;

import org.springframework.stereotype.*; 
import nonprof.org.org.tiers.nonprofit.Doman.VolunteerHours; 
import nonprof.org.org.tiers.nonprofit.Repo.VolunteerHouRepo; 
import java.util.List; 
import javax.transaction.Transactional; 

@Service
@Transactional
public class VolunteerHourService {
	private final VolunteerHouRepo volunteerHourRepo; 
	
	public VolunteerHourService(VolunteerHouRepo volunteerHourRepo) {
		this.volunteerHourRepo = volunteerHourRepo; 
	}
	
	public List<VolunteerHours> findAllVolunteerHours() {
		return this.volunteerHourRepo.findAll(); 
	}
	
	public VolunteerHours updateVolunteerHour(VolunteerHours volunteerHour) {
		return this.volunteerHourRepo.save(volunteerHour); 
	}
	
	public List<VolunteerHours> findVolunteerHoursByID(Long ID) {
		return this.volunteerHourRepo.findVolHoursByID(ID); 
	}
}