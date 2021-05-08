package nonprof.org.org.tiers.nonprofit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import nonprof.org.org.tiers.nonprofit.Doman.Donor;

public interface donoRepo extends JpaRepository<Donor, Long> {
	List<Donor> findDonorByID(Long ID);
}