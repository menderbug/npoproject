package nonprof.org.org.tiers.nonprofit.Doman;

import javax.persistence.*;

@Entity
public class Volunteeee {
	
	@Id
	private long volunteerID; 
	private long nonprofitID; 
	private String deptName; 
	private String volName; 
	private String volGender; 
	private String volAddress; 
	private String volEmail; 
	private int phoneNumb; 
	
	public Volunteeee() {
		;
	}
	
	public Volunteeee(String volName, String volEmail, int phone) {
		this.volName = volName; 
		this.volEmail = volEmail; 
		this.phoneNumb = phone; 
	}
	
	public Volunteeee(long volID, String volName, String volEmail, int phone) {
		this.volunteerID = volID; 
		this.volName = volName; 
		this.volEmail = volEmail; 
		this.phoneNumb = phone; 
	}
	
	public Volunteeee(long npoID, String deptName, String volName, String volGender, 
			String volAddress, String email, int phone) {
		this.nonprofitID = npoID; 
		this.deptName = deptName; 
		this.volName = volName; 
		this.volGender = volGender; 
		this.volAddress = volAddress; 
		this.volEmail = email; 
		this.phoneNumb = phone; 
	}
	
	public long getVolID() {
		return this.volunteerID; 
	}
	
	public void setVolID(long volID) {
		this.volunteerID = volID;
	}
	
	public long getNpoID() {
		return this.nonprofitID; 
	}
	
	public void setNpoID( long ID) {
		this.nonprofitID = ID; 
	}
	
	public String getDeptName() {
		return this.deptName; 
	}
	
	public void setDeptName(String name) {
		this.deptName = name; 
	}
	
	public String getVolName() {
		return this.volName;
	}
	
	public void setVolName(String name) {
		this.volName = name; 
	}
	
	public String getGender() {
		return this.volGender; 
	}
	
	public void setGender(String gender) {
		this.volGender = gender; 
	}
	
	public String getVolAddress() {
		return this.volAddress; 
	}
	
	public void setVolAddress(String address) {
		this.volAddress = address; 
	}
	
	public String getVolEmail() {
		return this.volEmail; 
	}
	
	public void setVolEmail(String email) {
		this.volEmail = email; 
	}
	
	public int getPhoneNumb() {
		return this.phoneNumb; 
	}
	
	public void setPhoneNumb(int phone) {
		this.phoneNumb = phone; 
	}
	
	@Override
	public String toString() {
		return "Volunteer{" +
				"id=" + this.volunteerID +
				", npoID='" + nonprofitID + '\'' +
	            ", deptName='" + this.deptName + '\'' +
	            ", name='" + volName + '\'' +
	            ", gender='" + volGender + '\'' +
	            ", address='" + volAddress + '\'' +
                ", email='" + this.volEmail + '\'' +
				", phone number=" + this.phoneNumb + '\'' +
                '}';
	}
	
}