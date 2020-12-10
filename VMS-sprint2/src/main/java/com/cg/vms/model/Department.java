package com.cg.vms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//------------------------ 1. OnlineVisaManagement Application --------------------------
/*******************************
 * -author        :   suriyaS
 -class           :   department POJO class
 -description     :   maintaining what are the fields required in the database
**********************************/
@Entity
@Table
public class Department {
/**
 * Attributes
 */
@Id
private long departmentId;
private String departmentName;

public long getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(long departmentId) {
	this.departmentId = departmentId;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public Department() {
	// TODO Auto-generated constructor stub
}
public Department(long departmentId, String departmentName) {
	super();
	this.departmentId = departmentId;
	this.departmentName = departmentName;
}

}