package nonprof.org.org.tiers.nonprofit.Doman;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employeeee {
	@Id
	private long empID; 
	private long nonprofitID; 
	private String deptName; 
	private String empName; 
	private String empGender; 
	private String empAddress; 
	private int phoneNumber; 
	private String empEmail; 
	private int salary; 
	
	public Employeeee() {
		;
	}
	
	public Employeeee(long npoID, String empName, int phoneNumber, int salary) {
		this.nonprofitID = npoID; 
		this.empName = empName; 
		this.phoneNumber = phoneNumber; 
		this.salary = salary; 
	}
	
	public Employeeee(long npoID, String deptName, String empName, 
			String empGender, String empAddress, int phoneNumber,
			String email, int salary) {
		this.nonprofitID = npoID; 
		this.deptName = deptName; 
		this.empName = empName; 
		this.empGender = empGender; 
		this.empAddress = empAddress; 
		this.phoneNumber = phoneNumber; 
		this.empEmail = email; 
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
	
	public String getDeptName() {
		return this.deptName; 
	}
	
	public void setDeptName(String name) {
		this.deptName = name; 
	}
	
	public String getEmpName() {
		return this.empName; 
	}
	
	public void setEmpName(String name) {
		this.empName = name; 
	}
	
	public String getGender() {
		return this.empGender; 
	}
	
	public void setGender(String gender) {
		this.empGender = gender; 
	}
	
	public String getEmpAddress() {
		return this.empAddress; 
	}
	
	public void setEmpAddress(String address) {
		this.empAddress = address; 
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
	
	public String getEmpEmail() {
		return this.empEmail; 
	}
	
	public void setEmpEmail(String email) {
		this.empEmail = email; 
	}
	
	 @Override
	    public String toString() {
	        return "Employee{" +
	                "id=" + empID +
	                ", npoID='" + nonprofitID + '\'' +
	                ", deptName='" + this.deptName + '\'' +
	                ", name='" + empName + '\'' +
	                ", gender='" + empGender + '\'' +
	                ", address='" + empAddress + '\'' +
	                ", phoneNumber='" + this.phoneNumber + '\'' +
	                ", email='" + empEmail + '\'' +
	                ", salary='" + this.salary + '\'' +
	                '}';
	    }
}