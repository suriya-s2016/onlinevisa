package com.cg.vms;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;


import com.cg.vms.model.User;


@SpringBootTest(classes = VmsSprint2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setUserName("Ashok");
		user.setEmailId("ashok@gmail.com");
		user.setPassword("Password%123");
		user.setPhoneNumber("123456");
		ResponseEntity<User> postResponse=restTemplate.postForEntity(getRootUrl()+"/user/adduser", user , User.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testLoginUser() {
		User user2 = new User("Ashok", "ashok@gmail.com", "Password%123", "123456");
		user2.setUserId(25L);
		user2 = restTemplate.getForObject(getRootUrl()+"/user/25/ashok@gmail.com/Password%123", User.class);
		assertNotNull(user2);
	}
}
