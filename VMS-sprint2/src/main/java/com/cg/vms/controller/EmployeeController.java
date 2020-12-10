package com.cg.vms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.exception.DepartmentNotFoundException;
import com.cg.vms.exception.EmployeeExistException;
import com.cg.vms.exception.EmployeeNotFoundException;
import com.cg.vms.model.Employee;
import com.cg.vms.service.DepartmentService;
import com.cg.vms.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	@Autowired
	private DepartmentService departmentService;
	
	//------------------------ 1. OnlineVisaManagement Application --------------------------
			/*******************************************************************************************
			         - Function Name	:	createEmployee
					 - Input Parameters	:	Employee object(request from client)
					 -  throws            :   EmployeeExistException, DepartmentNotFoundException
					 - Return Type		:	employee object
					 - Author			:	suriyaS
					 - Description		:	get the request from client as an object (use of @RequestBody annotation) and controller controls flow to service by calling getEmployeeById().
					                        Even checks id already present in database,if yes ,it throw an {@link EmployeeExistException} and checks department id is valid or not it throw {@link DepartmentNotFoundException} 
			    
			 *******************************************************************************************/
	@PostMapping("/newemp")
	public Employee createEmployee(@RequestBody Employee employee) throws EmployeeExistException, DepartmentNotFoundException
	{
		boolean checkExist=empService.getEmployeeById(employee.getEmployeeId()).isPresent(); 
		if(checkExist)
		{
			throw new EmployeeExistException("Employee Already present with this :"+employee.getEmployeeId());
		}
		departmentService.getDepartmentId(employee.getDepartment().getDepartmentId()).orElseThrow(()->new DepartmentNotFoundException("Department is invalid "));
		return empService.createEmployee(employee);
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
			/*******************************************************************************************
			         - Function Name	:	getAllEmployees
					 - Input Parameters	:	empty
					 - Return Type		:	list of employee object
					 - Author			:	suriyaS
					 - Description		:  it will fetch all the employee details from database by passing control to service by calling getEmployee()
			    
			 *******************************************************************************************/
	@GetMapping("/all")
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployee();
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
			/*******************************************************************************************
			         - Function Name	:	getEmployeeById
					 - Input Parameters	:	employeeId (from URL)
					 -  throws          :   EmployeetNotFoundException
					 - Return Type		:	ResponseEntity of employee object
					 - Author			:	suriyaS
					 - Description		:	get the request from client and get employee id from URL it fetches the data from database by calling service getEmployeeById() or it will throw an {@link EmployeeNotFoundException}
			    
			 *******************************************************************************************/
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="employeeId")long empId)throws EmployeeNotFoundException
	{
	Employee employee=empService.getEmployeeById(empId).orElseThrow(()->new EmployeeNotFoundException("No Employee found with this Id :"+empId));	
	return ResponseEntity.ok().body(employee);
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
	/*******************************************************************************************
	         - Function Name	:	getEmployeeByDepartment
			 - Input Parameters	:	departmentId (from URL)
			 -  throws          :   EmployeetNotFoundException
			 - Return Type		:	ResponseEntity of employee object
			 - Author			:	suriyaS
			 - Description		:	get the request from client and get employee id from URL it fetches the data from database by calling service getEmployeeByDepatment()
	    
	 *******************************************************************************************/
	@GetMapping("/department/{departmentid}")
	public List<Employee> getEmployeeByDepartment(@PathVariable(value="departmentid") long departmentId)
	{
		return empService.getEmployeeByDepatment(departmentId);
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
			/*******************************************************************************************
			         - Function Name	:	updateEmployee
					 - Input Parameters	:	employeeId(from URL) and  employee object(from @RquestBody)
					 - throws           :   EmployeeNotFoundException, DepartmentNotFoundException
					 - Return Type		:	ResponseEntity of employee object
					 - Author			:	suriyaS
					 - Description		:	update employee database whwn employeeId the matches in database by calling updateEmployee() or it throws EmployeeNotFoundException, DepartmentNotFoundException
			    
			 *******************************************************************************************/
	@PutMapping("/update/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="employeeId")long empId,@RequestBody Employee employee)throws EmployeeNotFoundException, DepartmentNotFoundException
	{
		Employee emp=empService.getEmployeeById(empId).orElseThrow(()->new EmployeeNotFoundException("No Employee found with this Id :"+empId));
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmailId(employee.getEmailId());
		emp.setPhoneNumber(employee.getPhoneNumber());
		emp.setCountry(employee.getCountry());
		departmentService.getDepartmentId(employee.getDepartment().getDepartmentId()).orElseThrow(()->new DepartmentNotFoundException("Department is invalid "));
		emp.setDepartment(employee.getDepartment());
		Employee updatedEmployee=empService.updateEmployee(emp);
		return ResponseEntity.ok(updatedEmployee); 
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
	/*******************************************************************************************
	         - Function Name	:	updateRoleEmployee
			 - Input Parameters	:	employeeId(from URL) and  employee object(from @RquestBody)
			 - throws           :   EmployeeNotFoundException
			 - Return Type		:	ResponseEntity of employee object
			 - Author			:	suriyaS
			 - Description		:	update role employee database when employeeId the matches in database by calling updateEmployee() or it throws EmployeeNotFoundException
	    
	 *******************************************************************************************/
	@PutMapping("/updaterole/{employeeId}")
	public ResponseEntity<Employee> updateRole(@PathVariable(value="employeeId")long empId,@RequestBody Employee employee)throws EmployeeNotFoundException
	{
		Employee emp=empService.getEmployeeById(empId).orElseThrow(()->new EmployeeNotFoundException("No Employee found with this Id :"+empId));
		emp.setRole(employee.getRole());
		Employee updatedEmployeeRole=empService.updateEmployee(emp);
		return ResponseEntity.ok(updatedEmployeeRole); 
	}
	//------------------------ 1. OnlineVisaManagement Application--------------------------
			/*******************************************************************************************
			         - Function Name	:	handleDepartmentNotFoundException
					 - Input Parameters	:	employeeId(from URL) and  employee object(from @RquestBody)
					 - throws           :   EmployeeNotFoundException
					 - Return Type		:	ResponseEntity of employee object
					 - Author			:	suriyaS
					 - Description		:	change the password with help of the id and replace the password with new one or else throw  EmployeeNotFoundException
			    
			 *******************************************************************************************/
	@PutMapping("/changepassword/{employeeId}")
	public ResponseEntity<Employee> changePassword(@PathVariable(value="employeeId")long empId,@RequestBody Employee employee)throws EmployeeNotFoundException
	{
		Employee emp=empService.getEmployeeById(empId).orElseThrow(()->new EmployeeNotFoundException("No Employee found with this Id :"+empId));
		emp.setPassword(employee.getPassword());
		Employee changeEmployeePassword=empService.updateEmployee(emp);
		return ResponseEntity.ok(changeEmployeePassword); 
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
			/*******************************************************************************************
			         - Function Name	:	deleteEmployee
					 - Input Parameters	:	employeeId(from URL) 
					 - throws           :   EmployeeNotFoundException
					 - Return Type		:	String
					 - Author			:	suriyaS
					 - Description		:	delete the employee from the database by calling deleteEmployee() or employee id not found it throws an EmployeeNotFoundException
			    
			 *******************************************************************************************/
	@DeleteMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable(value="employeeId")long empId)throws EmployeeNotFoundException
	{
		Employee emp=empService.getEmployeeById(empId).orElseThrow(()->new EmployeeNotFoundException("No Employee found with this Id :"+empId));
		empService.deleteEmployee(emp);
		return "Employee Deleted";
	}
}

