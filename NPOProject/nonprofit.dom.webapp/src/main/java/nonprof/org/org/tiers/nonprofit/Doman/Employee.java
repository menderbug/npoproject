package nonprof.org.org.tiers.nonprofit.Doman;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	private long empID; 
	private long nonprofitID; 
	private String empName; 
	private int phoneNumber; 
	private int salary; 
	
	public Employee() {
		;
	}
	
	public Employee(long npoID, String empName, int phoneNumber, int salary) {
		this.nonprofitID = npoID; 
		this.empName = empName; 
		this.phoneNumber = phoneNumber; 
		this.salary = salary; 
	}
	
	public long getEmpID() {
		return this.empID; 
	}
	
	public void setEmpID(long ID) {
		this.empID = ID; 
	}
	
	public long getNpoID() {
		return this.nonprofitID; 
	}
	
	public void setNpoID( long ID) {
		this.nonprofitID = ID; 
	}
	
	public String getEmpName() {
		return this.empName; 
	}
	
	public void setEmpName(String name) {
		this.empName = name; 
	}
	
	public int getPhoneNumber() {
		return this.phoneNumber; 
	}
	
	public void setPhoneNumber(int number) {
		this.phoneNumber = number; 
	}
	
	public int getSalary() {
		return this.salary; 
	}
	
	public void setSalary(int salary) {
		this.salary = salary; 
	}
	
	 @Override
	    public String toString() {
	        return "Employee{" +
	                "id=" + empID +
	                ", npoID='" + nonprofitID + '\'' +
	                ", name='" + empName + '\'' +
	                ", phoneNumber='" + this.phoneNumber + '\'' +
	                ", salary='" + this.salary + '\'' +
	                '}';
	    }
	
}