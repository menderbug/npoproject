package nonprof.org.org.tiers.nonprofit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; 
import nonprof.org.org.tiers.nonprofit.Doman.VolunteerHours;

public interface VolunteerHouRepo extends JpaRepository<VolunteerHours, Long> {
	List<VolunteerHours> findVolHoursByID(Long ID);
}