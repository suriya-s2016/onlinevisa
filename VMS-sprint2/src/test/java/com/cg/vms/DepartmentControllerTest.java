package com.cg.vms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


import com.cg.vms.model.Department;


@SpringBootTest(classes=VmsSprint2Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DepartmentControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl()
	{
		return "http://localhost:"+port;
	}
	/***********************************************************
	 * -function       :testCreateDepartment() 
	 * - author        :suriyaS
	 *  -description   :used to test the new department is added in database or not
	 ************************************************************/
	@Test
	void testCreateDepartment() {
		Department department=new Department(200, "saler");
		ResponseEntity<Department> postResponse=restTemplate.postForEntity(getRootUrl()+"/departments/newdepartment", department,Department.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	/***********************************************************
	 * -function       :testGetAllDepartments()
	 *  - author        :suriyaS
	 *  -description   :used to test the all department from database displayed or not
	 *  *********************************************************/
	@Test
	void testGetAllDepartments() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/departments/all",HttpMethod.GET,entity,String.class);
		assertNotNull(response.getBody());
	}

	/***********************************************************
	 * -function       :testUpdateDepartment()
	 *   - author        :suriyaS
	 *  -description   :used to test the given department were updated in database or not
	 *  *********************************************************/
	@Test
	void testUpdateDepartment() {
		Department department=restTemplate.getForObject(getRootUrl()+"/departments/200",Department.class);
		department.setDepartmentName("sale");
		restTemplate.put(getRootUrl()+"/departments/update/200", department);
		Department updateDepartment=restTemplate.getForObject(getRootUrl()+"/departments/200",Department.class);
		assertNotNull(updateDepartment);
	}

	/***********************************************************
	 * -function       :testDeleteEmployee()
	 *   - author        :suriyaS
	 *  -description   :used to test the  department deleted from database  or not
	 *  *********************************************************/
	@Test
	void testDeleteEmployee() {
		Department department=new Department(201, "saler");
		ResponseEntity<Department> postResponse=restTemplate.postForEntity(getRootUrl()+"/departments/newdepartment", department,Department.class);
		assertNotNull(postResponse);
		restTemplate.delete(getRootUrl()+"/departments/delete/201");
		Department deletedDepartment=restTemplate.getForObject(getRootUrl()+"/departments/200",Department.class);
		assertNotEquals(department, deletedDepartment);
		
	}

}
