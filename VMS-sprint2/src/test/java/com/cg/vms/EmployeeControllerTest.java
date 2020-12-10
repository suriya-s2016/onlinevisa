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
import com.cg.vms.model.Employee;




@SpringBootTest(classes=VmsSprint2Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl()
	{
		return "http://localhost:"+port;
	}
	/***********************************************************
	 * -function       :testCreateEmployee()  
	 *   - author        :suriyaS
	 *  -description   :used to test the new employee is added in database or not
	 ************************************************************/
	@Test
	void testCreateEmployee() {
		Department dept=new Department();
		dept.setDepartmentId(1);
		Employee employee=new Employee(200, "lashman", "Raj", "europe", "lash12@gmail.com",8, "laksh@345","analyst", dept);
		ResponseEntity<Employee> postResponse=restTemplate.postForEntity(getRootUrl()+"/employees/newemp", employee,Employee.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	/***********************************************************
	 * -function       :testGetAllEmployees()
	 *   - author        :suriyaS
	 *  -description   :used to test the all employee from database displayed or not
	 *  *********************************************************/
	@Test
	void testGetAllEmployees() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/employees/all",HttpMethod.GET,entity,String.class);
		assertNotNull(response.getBody());
	}

	/***********************************************************
	 * -function       :testGetEmployeeById()
	 *   - author        :suriyaS
	 *  -description   :used to test the particular data fetched from database or not
	 *  *********************************************************/
	@Test
	void testGetEmployeeById() {
		Department dept=new Department();
		dept.setDepartmentId(1);
		Employee employee=new Employee(200, "lashman", "Raj", "europe", "lash12@gmail.com",8, "laksh@345","analyst", dept);
		restTemplate.postForEntity(getRootUrl()+"/employees/newemp", employee,Employee.class);
		Employee emp=restTemplate.getForObject(getRootUrl()+"/employees/200",Employee.class);
		assertNotNull(emp);
	}

	/***********************************************************
	 * -function       :testUpdateEmployee()
	 *   - author        :suriyaS
	 *  -description   :used to test the given employee were updated in database or not
	 *  *********************************************************/
	@Test
	void testUpdateEmployee() {
		Employee emp=restTemplate.getForObject(getRootUrl()+"/employees/200",Employee.class);
        emp.setLastName("kumar");
		restTemplate.put(getRootUrl()+"/employees/update/200", emp);
		Employee updateEmployee=restTemplate.getForObject(getRootUrl()+"/employees/200",Employee.class);
		assertNotNull(updateEmployee);
	}
	
	/***********************************************************
	 * -function       :testUpdateRole()
	 *   - author        :suriyaS
	 *  -description   :used to test the given employee role were updated in database or not
	 *  *********************************************************/

	@Test
	void testUpdateRole() {
		Employee emp=restTemplate.getForObject(getRootUrl()+"/employees/200",Employee.class);
        emp.setRole("A4");
		restTemplate.put(getRootUrl()+"/employees/update/200", emp);
		Employee updateEmployee=restTemplate.getForObject(getRootUrl()+"/employees/200",Employee.class);
		assertNotNull(updateEmployee);
	}
	/***********************************************************
	 * -function       :testChangePassword()
	 *   - author        :suriyaS
	 *  -description   :used to test the given employee password were updated in database or not
	 *  *********************************************************/

	@Test
	void testChangePassword() {
		Employee emp=restTemplate.getForObject(getRootUrl()+"/employees/200",Employee.class);
        emp.setPassword("laks123789");
		restTemplate.put(getRootUrl()+"/employees/update/200", emp);
		Employee updateEmployee=restTemplate.getForObject(getRootUrl()+"/employees/200",Employee.class);
		assertNotNull(updateEmployee);
	}
	
	/***********************************************************
	 * -function       :testDeleteEmployee()
	 *   - author        :suriyaS
	 *  -description   :used to test the  employee deleted from database  or not
	 *  *********************************************************/

	@Test
	void testDeleteEmployee() {
		Department dept=new Department();
		dept.setDepartmentId(1);
		Employee employee=new Employee(201, "lashman", "Raj", "europe", "lash12@gmail.com",8, "laksh@345","analyst", dept);
		ResponseEntity<Employee> postResponse=restTemplate.postForEntity(getRootUrl()+"/employees/newemp", employee,Employee.class);
		assertNotNull(postResponse);
		restTemplate.delete(getRootUrl()+"/employees/delete/201");
			Employee emp1=restTemplate.getForObject(getRootUrl()+"/employees/201",Employee.class);
			assertNotEquals(employee,emp1);
	}

}
