package com.infob.dummygradle.model;

public class Employee {

    private int id;
	private long empId;
	private String name;
	private String mobileNumber;
	private String emailId;
	public Employee() {
		super();
	}
	public Employee(int id, long empId, String name, String mobileNumber, String emailId) {
		super();
		this.id = id;
		this.empId = empId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", name=" + name + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + "]";
	}
}
