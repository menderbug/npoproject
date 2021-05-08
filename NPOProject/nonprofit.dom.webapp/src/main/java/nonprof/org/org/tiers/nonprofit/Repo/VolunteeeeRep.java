package nonprof.org.org.tiers.nonprofit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import nonprof.org.org.tiers.nonprofit.Doman.Volunteeee;

public interface VolunteeeeRep extends JpaRepository<Volunteeee, Long> {
	List<Volunteeee> findVolunteeeeByID(Long ID);
}