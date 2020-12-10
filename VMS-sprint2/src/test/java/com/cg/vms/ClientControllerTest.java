package com.cg.vms;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;


import com.cg.vms.model.Client;

@SpringBootTest(classes = VmsSprint2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ClientControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	public void testApplyVisa() {
		Client client = new Client();
		client.setPassportNumber("AAAA2345");
		client.setPanNumber("ABCD1234Z");
		client.setQualification("Graduate");
		client.setCountry("UK");
		client.setTypeOfVisa("tourist");
		client.setStatus("new application");
		ResponseEntity<Client> postResponse=restTemplate.postForEntity(getRootUrl()+"/client/applyvisa", client , Client.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testViewStatus() {
		Client client = new Client("AAAA2345", "ABCD1234Z", "Graduate", "UK", "tourist", "new application");
		client.setClientId(100L);
		client = restTemplate.getForObject(getRootUrl()+"/client/viewstatus/100", Client.class);
		assertNotNull(client);
	}
}
