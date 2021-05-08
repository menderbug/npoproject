package nonprof.org.org.tiers.nonprofit.Service;

import org.springframework.*;
import nonprof.org.org.tiers.nonprofit.Doman.Donor;
import nonprof.org.org.tiers.nonprofit.Repo.donoRepo;
import java.util.List; 
import javax.transaction.Transactional; 
import org.springframework.stereotype.*;


@Service
@Transactional
public class DonorService {
	private final donoRepo donorRepos;
	
	public DonorService(donoRepo donorRepos) {
		this.donorRepos = donorRepos; 
	}
	
	public List<Donor> findAllDonors() {
		return donorRepos.findAll();
	}
	
	public Donor updateDonor(Donor donor) {
		return donorRepos.save(donor); 
	}
	
	public List<Donor> findDonorByID(Long ID) {
		return donorRepos.findDonorByID(ID); 
	}
}