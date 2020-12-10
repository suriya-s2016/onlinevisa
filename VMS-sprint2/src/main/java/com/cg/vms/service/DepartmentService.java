package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.model.Department;

import com.cg.vms.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	//------------------------ 1. OnlineVisaManagement Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	createDepartment
	 - Input Parameters	:	department object
	 - Return Type		:	department object
	 - Author			:	suriyaS
	 - Description		:	adding the department details to database by calling department repository
	 ********************************************************************************************************/
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:	getDepartmentId
			 - Input Parameters	:	department id
			 - Return Type		:	optional department object
			 - Author			:	suriyaS
			 - Description		:	get  department from database by calling findById() in department repository 
			 ********************************************************************************************************/
	public Optional<Department> getDepartmentId(long departmentId) {
		return departmentRepository.findById(departmentId);
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
		/*******************************************************************************************************
		 - Function Name	:	getAllEmployee
		 - Input Parameters	:	empty
		 - Return Type		:	List of employee object
		 - Author			:	suriyaS
		 - Description		:	get all employee details from database by calling findAll() in employee repository 
		 ********************************************************************************************************/
		public List<Department> getAllDepartments()
		{
			return departmentRepository.findAll();
		}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	updateDepartment
	 - Input Parameters	:	department object
	 - Return Type		:	department object
	 - Author			:	suriyaS
	 - Description		:	update the department details in database and save it by calling findById() in department repository 
	 ********************************************************************************************************/
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}
	//------------------------ 1. OnlineVisaManagement Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:	deleteDepartment
			 - Input Parameters	:	department object
			 - Return Type		:	department object
			 - Author			:	suriyaS
			 - Description		:	delete the department from database by calling delete() in department repository 
			 ********************************************************************************************************/
	public void deleteDepartment(Department deparmentInDB) {
		departmentRepository.delete(deparmentInDB);
		
	}



}
