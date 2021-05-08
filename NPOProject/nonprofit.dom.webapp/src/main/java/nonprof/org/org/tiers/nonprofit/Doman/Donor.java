package nonprof.org.org.tiers.nonprofit.Doman;

import javax.persistence.*;


@Entity
public class Donor {
	@Id
	private long donorID; 
	private String donorName; 
	private String donorAddress; 
	private String donorEmail; 
	
	public Donor() {
		;
	}
	
	public Donor( String donorName, String donorAddress, String donorEmail) {
		this.donorName = donorName; 
		this.donorAddress = donorAddress; 
		this.donorEmail = donorEmail; 
	}
	
	public long getDonorID() {
		return this.donorID; 
	}
	
	public void setDonorID( long ID) {
		this.donorID = ID; 
	}
	
	public String getDonorName() {
		return this.donorName; 
	}
	
	public void setDonorName( String name) {
		this.donorName = name; 
	}
	
	public String getDonorAddress() {
		return this.donorAddress; 
	}
	
	public void setDonorAddress( String address) {
		this.donorAddress = address; 
	}
	
	public String getDonorEmail() {
		return this.donorEmail; 
	}
	
	public void setDonorEmail(String email) {
		this.donorEmail = email; 
	}
	
	@Override
	public String toString() {
		return "Donor{" +
				"ID=" + this.donorID +
				", name='" + donorName + '\'' +
				", address='" + donorAddress + '\'' +
                ", email='" + donorEmail + '\'' +
                '}';
	}
	
}