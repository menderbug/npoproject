package nonprof.org.org.tiers.nonprofit.Doman;

import javax.persistence.*;

@Entity
public class Department {
	private String deptName; 
	private String director; 
	private int budget; 
	private long nonprofitID; 
	
	public Department() {
		;
	}
	
	public Department(String deptName, String director, int budget, long npoID) {
		this.deptName = deptName; 
		this.director = director; 
		this.budget = budget; 
		this.nonprofitID = npoID; 
	}
	
	public String getDeptName() {
		return this.deptName; 
	}
	
	public void setDeptName(String name) {
		this.deptName = name; 
	}
	
	public String getDirector() {
		return this.director; 
	}
	
	public void setDirector(String director) {
		this.director = director; 
	}
	
	public int getBudget() {
		return this.budget; 
	}
	
	public void setBudget(int budget) {
		this.budget = budget; 
	}
	
	public long getNpoID() {
		return this.nonprofitID; 
	}
	
	public void setNpoID( long ID) {
		this.nonprofitID = ID; 
	}
	
	@Override
	public String toString() {
		return "Department{" +
				"name=" + this.deptName +
				", director='" + this.director + '\'' +
                ", budget='" + this.budget + '\'' +
				", npoID=" + this.nonprofitID + '\'' +
                '}';
	}
	
}