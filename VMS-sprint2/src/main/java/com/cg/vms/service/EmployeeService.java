package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.model.Employee;
import com.cg.vms.repository.EmployeeRepository;


@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepository;
	//------------------------ 1. OnlineVisaManagement Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:	createEmployee
			 - Input Parameters	:	employee object
			 - Return Type		:	 Employee
			 - Author			:	suriyaS
			 - Description		:	adding the employee details to database by calling employee repository
			 ********************************************************************************************************/
	public Employee createEmployee(Employee employee)
	{
		return empRepository.save(employee);
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	getAllEmployee
	 - Input Parameters	:	empty
	 - Return Type		:	List of employee object
	 - Author			:	suriyaS
	 - Description		:	get all employee details from database by calling findAll() in employee repository 
	 ********************************************************************************************************/
	public List<Employee> getAllEmployee()
	{
		return empRepository.findAll();
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
		/*******************************************************************************************************
		 - Function Name	:	getEmployeeById
		 - Input Parameters	:	employee id
		 - Return Type		:	optional employee object
		 - Author			:	suriyaS
		 - Description		:	get  employee from database by calling findById() in employee repository 
		 ********************************************************************************************************/
	public Optional<Employee> getEmployeeById(long id)
	{
		return empRepository.findById(id);
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:	getEmployeeByDepatment
			 - Input Parameters	:	department id
			 - Return Type		:	List of employee object
			 - Author			:	suriyaS
			 - Description		:	get  all employee from database based on the department by calling findByDepartment() in employee repository 
			 ********************************************************************************************************/
	public List<Employee> getEmployeeByDepatment(long departmentId)
	{
		return empRepository.findByDepartment(departmentId);
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:	updateEmployee
			 - Input Parameters	:	employee object
			 - Return Type		:	employee object
			 - Author			:	suriyaS
			 - Description		:	update the employee details in database and save it by calling findById() in employee repository 
			 ********************************************************************************************************/
	public Employee updateEmployee(Employee employee)
	{
		return empRepository.save(employee);
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
		/*******************************************************************************************************
		 - Function Name	:	deleteEmployee
		 - Input Parameters	:	employee object
		 - Return Type		:	employee object
		 - Author			:	suriyaS
		 - Description		:	delete the employee from database by calling delete() in employee repository 
		 ********************************************************************************************************/
	public void deleteEmployee(Employee employee)
	{
		empRepository.delete(employee);
	}

}

