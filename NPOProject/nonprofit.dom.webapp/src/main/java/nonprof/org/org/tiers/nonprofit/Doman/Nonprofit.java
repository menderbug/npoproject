package nonprof.org.org.tiers.nonprofit.Doman;

import javax.persistence.*;


@Entity
public class Nonprofit { 
	@Id
	private long nonprofitID; 
	private String npoName; 
	private String npoAddress; 
	private String npoEmail; 
	
	public Nonprofit() {
		;
	}
	
	public Nonprofit( String npoName, String npoAddress, String npoEmail) {
		this.npoName = npoName; 
		this.npoAddress = npoAddress; 
		this.npoEmail = npoEmail; 
	}
	
	public long getNpoID() {
		return this.nonprofitID; 
	}
	
	public void setNpoID( long ID) {
		this.nonprofitID = ID; 
	}
	
	public String getNpoName() {
		return this.npoName; 
	}
	
	public void setNpoName( String name) {
		this.npoName = name; 
	}
	
	public String getNpoAddress() {
		return this.npoAddress; 
	}
	
	public void setNpoAddress( String address) {
		this.npoAddress = address; 
	}
	
	public String getNpoEmail() {
		return this.npoEmail; 
	}
	
	public void setNpoEmail(String email) {
		this.npoEmail = email; 
	}
	
	@Override
	public String toString() {
		return "Nonprofit{" +
				"ID=" + this.nonprofitID +
				", name='" + npoName + '\'' +
				", address='" + npoAddress + '\'' +
                ", email='" + npoEmail + '\'' +
                '}';
	}
	
}