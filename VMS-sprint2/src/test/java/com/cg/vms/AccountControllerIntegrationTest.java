package com.cg.vms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.cg.vms.model.Account;

@SpringBootTest(classes=VmsSprint2Application.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerIntegrationTest {

	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	public void testInserData() {
		Account acc=new Account((long) 110,"NetBanking",3500.0,"Pending");
		ResponseEntity<Account> postResponse=restTemplate.postForEntity(getRootUrl()+"/account/add", acc, Account.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());	
	}
	
	@Test
	public void testViewAllAccounts() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/account/all",HttpMethod.GET,entity,String.class);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testViewAccount() {
		Account acc=restTemplate.getForObject(getRootUrl()+"/account/110", Account.class);
		assertNotNull(acc);
	}
	
	@Test
	public void testDeleteAccount() {
		Account acc = restTemplate.getForObject(getRootUrl()+"/account/110", Account.class);
		assertNotNull(acc);
		restTemplate.delete(getRootUrl()+"/account/110");
		try {
			acc = restTemplate.getForObject(getRootUrl()+"/account/110",Account.class);
		}
		catch(final HttpClientErrorException ex) {
			assertEquals(ex.getStatusCode(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}
