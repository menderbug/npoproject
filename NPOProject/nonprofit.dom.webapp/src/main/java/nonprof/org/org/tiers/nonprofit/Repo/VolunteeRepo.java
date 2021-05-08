package nonprof.org.org.tiers.nonprofit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; 
import nonprof.org.org.tiers.nonprofit.Doman.Volunteer;

public interface VolunteeRepo extends JpaRepository<Volunteer, Long> {
	List<Volunteer> findVolunteerByID(Long ID);
}