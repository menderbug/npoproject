package nonprof.org.org.tiers.nonprofit.Doman;

import javax.persistence.*;

@Entity
public class VolunteerHours {
	private long volunteerID; 
	private long nonprofitID; 
	private int year; 
	private int month; 
	private int day; 
	private int numHours; 
	
	public VolunteerHours() {
		;
	}
	
	public VolunteerHours(long volunteerID, long npoID, int year, 
			int month, int day, int hour) {
		this.volunteerID = volunteerID; 
		this.nonprofitID = npoID; 
		this.year = year; 
		this.month = month; 
		this.day = day; 
		this.numHours = hour; 
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
	
	public int getYear() {
		return this.year; 
	}
	
	public void setYear(int year) {
		this.year = year; 
	}
	
	public int getMonth() {
		return this.month; 
	}
	
	public void setMonth(int month) {
		this.month = month; 
	}
	
	public int getDay() {
		return this.day; 
	}
	
	public void setDay(int day) {
		this.day = day; 
	}
	
	public int getNumHours() {
		return this.numHours; 
	}
	
	public void setNumHours(int hours) {
		this.numHours = hours; 
	}
	
	@Override
	public String toString() {
		return "Volunteer Hours{" +
				"volunteerID=" + this.volunteerID +
				"npoID=" + this.nonprofitID + '\'' +
				", year='" + year + '\'' +
				", month='" + this.month + '\'' +
                ", day='" + this.day + '\'' +
                ", number of Hours='" + this.numHours + '\'' +
                '}';
	}
}