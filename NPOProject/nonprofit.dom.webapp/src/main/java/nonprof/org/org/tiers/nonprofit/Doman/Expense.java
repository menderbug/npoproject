package nonprof.org.org.tiers.nonprofit.Doman;

import javax.persistence.*;


@Entity
public class Expense {
	@Id
	private long expID; 
	private long nonprofitID; 
	private int year; 
	private int month; 
	private int day; 
	private String type; 
	private long amount; 
	
	public Expense() {
		;
	}
	
	public Expense(long npoID, int year, int month, int day, 
			String type, long amount) {
		this.nonprofitID = npoID; 
		this.year = year;
		this.month = month; 
		this.day = day; 
		this.type =type; 
		this.amount = amount; 
	}
	
	public long getExpID() {
		return this.expID; 
	}
	
	public void setExpID(long ID) {
		this.expID = ID; 
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
	
	public String getType() {
		return this.type; 
	}
	
	public void setType(String type) {
		this.type = type; 
	}
	
	public long getAmount() {
		return this.amount; 
	}
	
	public void setAmount(long amount) {
		this.amount = amount; 
	}
	
	@Override
	public String toString() {
		return "Expense{" +
				"expID=" + this.expID +
				"npoID=" + this.nonprofitID + '\'' +
				", year='" + year + '\'' +
				", month='" + this.month + '\'' +
                ", day='" + this.day + '\'' +
                ", type='" + this.type + '\'' +
                ", amount='" + this.amount + '\'' +
                '}';
	}
	
}