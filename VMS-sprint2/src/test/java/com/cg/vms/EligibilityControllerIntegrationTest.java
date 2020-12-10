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

import com.cg.vms.model.Eligibility;

@SpringBootTest(classes=VmsSprint2Application.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EligibilityControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	public void testInserData() {
		Eligibility e=new Eligibility("RUS","Russia","Russian","Graduate");
		ResponseEntity<Eligibility> postResponse=restTemplate.postForEntity(getRootUrl()+"/eligibility/add", e, Eligibility.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());	
	}
	
	@Test
	public void testGetAllEligibilityDetails() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/eligibility/all",HttpMethod.GET,entity,String.class);
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testViewData() {
		Eligibility e=restTemplate.getForObject(getRootUrl()+"/eligibility/AUS", Eligibility.class);
		assertNotNull(e);
	}
	
	@Test
	public void testDeleteData() {
		Eligibility e = restTemplate.getForObject(getRootUrl()+"/eligibility/RUS", Eligibility.class);
		assertNotNull(e);
		restTemplate.delete(getRootUrl()+"/eligibility/RUS");
		try {
			e = restTemplate.getForObject(getRootUrl()+"/eligibility/RUS", Eligibility.class);
		}
		catch(final HttpClientErrorException ex) {
			assertEquals(ex.getStatusCode(),HttpStatus.NOT_FOUND);
		}
		
	}
	
}
