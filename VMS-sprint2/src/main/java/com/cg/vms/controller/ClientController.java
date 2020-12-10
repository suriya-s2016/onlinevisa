package com.cg.vms.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.exception.UserNotFoundException;
import com.cg.vms.model.Client;
import com.cg.vms.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
	
	@PostMapping("/applyvisa")
	public Client applyVisa(@Valid @RequestBody Client client) {
		return clientService.applyVisa(client);
	}
	
	@GetMapping("/visastatus/{clientId}")
	public String visaStatus(@PathVariable Long clientId) throws UserNotFoundException {
		return getClientService().visaStatus(clientId);
	}
}
