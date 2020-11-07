package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="empID")
	private int employeeID;
	
	@Column(name="empName")
	private String employeeName;
	
	@Column(name="empPassword")
	private String employeePass;
	


	@Column(name="empSalary")
	private float employeeSalary;
	
	@Column(name="empPhoneNo")
	private long employeecontactno;
	



	@Column(name="empMailID")
	private String employeemail;
	
	
	public Employee(int employeeID) {
		this.employeeID = employeeID;
	}

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getEmployeeID() {
		return employeeID;
	}
	
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	
	public String getEmployeePass() {
		return employeePass;
	}
	
	
	public void setEmployeePass(String employeePass) {
		this.employeePass = employeePass;
	}
	
	
	public float getEmployeeSalary() {
		return employeeSalary;
	}
	
	
	public void setEmployeeSalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	

	
	
	public long getEmployeecontactno() {
		return employeecontactno;
	}
	public void setEmployeecontactno(long employeecontactno) {
		this.employeecontactno = employeecontactno;
	}


	public String getEmployeemail() {
		return employeemail;
	}
	
	
	public void setEmployeemail(String employeemail) {
		this.employeemail = employeemail;
	}
	
	
	@Override
	public String toString() {
		return  employeeID + " " + employeeName + " "
				+ employeePass + " " + employeeSalary + " " + employeecontactno
				+ " " + employeemail ;
	}
	
	
	
	
	
	
	
}
