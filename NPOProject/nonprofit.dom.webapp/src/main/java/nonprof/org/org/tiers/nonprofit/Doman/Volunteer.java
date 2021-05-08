package nonprof.org.org.tiers.nonprofit.Doman;

import javax.persistence.*;


@Entity
public class Volunteer {
	@Id
	private long volunteerID; 
	private String volName; 
	private String volEmail; 
	private int phoneNumb; 
	
	public Volunteer() {
		;
	}
	
	public Volunteer(String volName, String volEmail, int phone) {
		this.volName = volName; 
		this.volEmail = volEmail; 
		this.phoneNumb = phone; 
	}
	
	public Volunteer(long volID, String volName, String volEmail, int phone) {
		this.volunteerID = volID; 
		this.volName = volName; 
		this.volEmail = volEmail; 
		this.phoneNumb = phone; 
	}
	
	public long getVolID() {
		return this.volunteerID; 
	}
	
	public void setVolID(long volID) {
		this.volunteerID = volID;
	}
	
	public String getVolName() {
		return this.volName;
	}
	
	public void setVolName(String name) {
		this.volName = name; 
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
				", name='" + this.volName + '\'' +
                ", email='" + this.volEmail + '\'' +
				", phone number=" + this.phoneNumb + '\'' +
                '}';
	}
	
}