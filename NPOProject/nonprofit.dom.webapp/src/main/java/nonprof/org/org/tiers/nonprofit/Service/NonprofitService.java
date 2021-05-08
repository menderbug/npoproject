package nonprof.org.org.tiers.nonprofit.Service;

import org.springframework.*;
import nonprof.org.org.tiers.nonprofit.Doman.Nonprofit;
import nonprof.org.org.tiers.nonprofit.Repo.NpoRepo; 
import java.util.List; 
import javax.transaction.Transactional;
import org.springframework.stereotype.*;


@Service
@Transactional
public class NonprofitService {
	private final NpoRepo npoRepo; 
	
	public NonprofitService(NpoRepo npoRepo) {
		this.npoRepo = npoRepo; 
	}
	
	public List<Nonprofit> findAllNonprofits() {
		return npoRepo.findAll();
	}
	
	public Nonprofit updateNonprofit(Nonprofit nonprofit) {
		return npoRepo.save(nonprofit);
	}
	
	public List<Nonprofit> findNonprofitByID(Long ID) {
		return this.npoRepo.findNpoByID(ID); 
	}
	
	/*public List<Nonprofit> findNonprofitByID(Long ID) {
		try {
			return npoRepo.findNpoByID(ID);
		}
			
			catch (Exception e) {
				e.printStackTrace();
				//return new List<Nonprofit> = nonprofitList;
			}
	} */
}