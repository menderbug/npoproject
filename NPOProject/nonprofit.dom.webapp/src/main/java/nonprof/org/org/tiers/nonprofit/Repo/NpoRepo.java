package nonprof.org.org.tiers.nonprofit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import nonprof.org.org.tiers.nonprofit.Doman.Nonprofit;

public interface NpoRepo extends JpaRepository<Nonprofit, Long> {
	List<Nonprofit> findNpoByID(Long ID);
}