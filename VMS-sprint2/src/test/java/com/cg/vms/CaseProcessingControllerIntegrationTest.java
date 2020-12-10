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

import com.cg.vms.model.CaseProcessing;

@SpringBootTest(classes=VmsSprint2Application.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CaseProcessingControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	public void testCreateCaseProcessing() {
		CaseProcessing cp= new CaseProcessing();
		cp.setClientId(101);
		cp.setProcessingStatus("success");
		ResponseEntity<CaseProcessing> postResponce=restTemplate.postForEntity(getRootUrl()+"/processing/add", cp,CaseProcessing.class);
		assertNotNull(postResponce);
		assertNotNull(postResponce.getBody());
	}
	
	@Test
	public void testgetAllCaseProcessing() {
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> responce=restTemplate.exchange(getRootUrl()+"/processing/all",HttpMethod.GET,entity,String.class);
		assertNotNull(responce.getBody());
	}
	@Test
	public void testGetCaseProcessingById() {
		CaseProcessing cp= new CaseProcessing();
		cp.setClientId(101);
		cp.setProcessingStatus("success");
		restTemplate.postForEntity(getRootUrl()+"/processing/add", cp,CaseProcessing.class);
		CaseProcessing cp1=restTemplate.getForObject(getRootUrl()+"/processing/101",CaseProcessing.class);
		System.out.println(cp1.getClientId()+" "+cp1.getProcessingStatus());
		assertNotNull(cp1);
	}
	@Test 
	public void testUpdateCaseProcessing() {
		CaseProcessing cp=restTemplate.getForObject(getRootUrl()+"/processing/101",CaseProcessing.class);
		cp.setProcessingStatus("Visa Approved");
		restTemplate.put(getRootUrl()+"/processing/update", cp);
		CaseProcessing updatedCaseProcessing=restTemplate.getForObject(getRootUrl()+"/processing/101",CaseProcessing.class);
		assertNotNull(updatedCaseProcessing);
	}

	@Test 
	public void testDeleteCaseProcessing() {
		CaseProcessing cp=restTemplate.getForObject(getRootUrl()+"/processing/101",CaseProcessing.class);
		assertNotNull(cp);
		restTemplate.delete(getRootUrl()+"/processing/101");
		try {
			cp=restTemplate.getForObject(getRootUrl()+"/processing/101", CaseProcessing.class);
		}
		catch(final HttpClientErrorException e){
			assertEquals(e.getStatusCode(),HttpStatus.NOT_FOUND);
		}
	}
}