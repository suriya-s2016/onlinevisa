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
import org.springframework.http.ResponseEntity;

import com.cg.vms.model.Visa;

@SpringBootTest(classes=VmsSprint2Application.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VisaControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate; //display the output in console with out using postman
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	public void testCreateVisa()
	{
		Visa visa=new Visa();
		visa.setVisaId(106);
		visa.setVisaName("conference");
		visa.setPeriod(2);
		visa.setProcessingFee(2000);
		ResponseEntity<Visa> postResponse=restTemplate.postForEntity(getRootUrl()+"/visa/newvisa",visa,Visa.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testGetAllVisa()
	{
		HttpHeaders header=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,header);
		ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/visa/all",HttpMethod.GET ,entity,String.class);
		System.out.println(response.getBody());
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testGetVisaById()
	{
		Visa visa=restTemplate.getForObject(getRootUrl()+"/visa/106",Visa.class);
		System.out.println(visa.getVisaId()+" "+visa.getVisaName()+" "+visa.getPeriod()+" "+visa.getProcessingFee());
		assertEquals(visa.getVisaId(),106);
	}

}
