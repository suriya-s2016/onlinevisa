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
import com.cg.vms.model.Department;
import com.cg.vms.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	

	//------------------------ 1. OnlineVisaManagement Application --------------------------
			/*******************************************************************************************
			         - Function Name	:	createDepartment
					 - Input Parameters	:	department object(request from client)
					 - Return Type		:	department object
					 - Author			:	suriyaS
					 - Description		:	get the request from client as an object (use of @RequestBody annotation) and controller controls flow to service by calling createDepartment() 
			    
			 *******************************************************************************************/
	
	@PostMapping("/newdepartment")
	public Department createDepartment(@RequestBody Department department)
	{
		return departmentService.createDepartment(department);
	}
	//------------------------1. OnlineVisaManagement Application --------------------------
	/*******************************************************************************************
	         - Function Name	:	getAllDepartment
			 - Input Parameters	:	empty
			 - Return Type		:	list of department object
			 - Author			:	suriyaS
			 - Description		:  it will fetch all the department details from database by passing control to service by calling getallDepartment()
	    
	 *******************************************************************************************/
    @GetMapping("/all")
   public List<Department> getAllDepartments()
   {
    return departmentService.getAllDepartments();
   }
	//------------------------ 1. OnlineVisaManagement Application--------------------------
	/*******************************************************************************************
	         - Function Name	:	updateDepartment
			 - Input Parameters	:	departmentId(from URL) and  department object(from @RquestBody)
			 - throws           :   DepartmentNotFoundException
			 - Return Type		:	ResponseEntity of department object
			 - Author			:	suriyaS
			 - Description		:	update department database when departmentId the matches in database by calling updateDepartment() or it throws DepartmentNotFoundException
	    
	 *******************************************************************************************/
	@PutMapping("/update/{departmentid}")
	public ResponseEntity<Department> updateDepartment(@PathVariable(value="departmentid")long departmentId,@RequestBody Department department)throws DepartmentNotFoundException
	{
		Department deparmentInDB=departmentService.getDepartmentId(departmentId).orElseThrow(()->new DepartmentNotFoundException("No Employee found with this Id :"+departmentId));
		deparmentInDB.setDepartmentName(department.getDepartmentName());
		Department updatedDepartment=departmentService.updateDepartment(deparmentInDB);
		return ResponseEntity.ok(updatedDepartment); 
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
	/*******************************************************************************************
	         - Function Name	:	deleteDepartment
			 - Input Parameters	:	departmentId(from URL) 
			 - throws           :   DepartmentNotFoundException
			 - Return Type		:	String
			 - Author			:	suriyaS
			 - Description		:	delete the department from the database by calling deleteDepartment() or employee id not found it throws an DepartmentNotFoundException
	    
	 *******************************************************************************************/
	@DeleteMapping("/delete/{departmentid}")
	public String deleteEmployee(@PathVariable(value="departmentid")long departmentId)throws DepartmentNotFoundException
	{
		Department deparmentInDB=departmentService.getDepartmentId(departmentId).orElseThrow(()->new DepartmentNotFoundException("No Employee found with this Id :"+departmentId));
		departmentService.deleteDepartment(deparmentInDB);
		return "Department Deleted";
	}

}
