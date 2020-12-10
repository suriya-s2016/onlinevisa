package com.cg.vms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//------------------------ 1. OnlineVisaManagement Application --------------------------
/*******************************
 * -author          :   suriyaS
   -class           :   employee POJO class
   -description     :   maintaining what are the fields required in the database
 **********************************/
@Entity
@Table(name = "employee")
public class Employee {
	/**
	 * Attributes
	 */
	@Id
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String country;
	private String emailId;
	private long phoneNumber;
	private String password;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@ManyToOne
	Department department;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
public Employee(long employeeId, String firstName, String lastName, String country, String emailId,
			long phoneNumber, String password, String role, Department department) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
		this.department = department;
	}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return getEmployeeId()+"\t"+getFirstName()+"\t"+getLastName()+"\t"+getCountry()+"\t"+getPhoneNumber()+"\t"+getDepartment().getDepartmentName()+"\t"+getRole()+"\t"+getEmailId();
}
}