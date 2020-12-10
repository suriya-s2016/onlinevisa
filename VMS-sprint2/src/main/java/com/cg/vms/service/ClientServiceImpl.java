package com.cg.vms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.exception.UserNotFoundException;
import com.cg.vms.model.Client;
import com.cg.vms.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepo;
	

	public ClientRepository getClientRepo() {
		return clientRepo;
	}



	public void setClientRepo(ClientRepository clientRepo) {
		this.clientRepo = clientRepo;
	}



	@Override
	public Client applyVisa(Client client) {
		return clientRepo.save(client);
	}



	@Override
	public String visaStatus(Long clientId) throws UserNotFoundException{
		
		Optional<Client> client = getClientRepo().findById(clientId);
		try {
			if(client.isPresent()) {
				return client.get().getStatus();
			}
			else {
				throw new UserNotFoundException("please mention correct Client_ID");
			}
		}catch (UserNotFoundException e) {
			e.getMessage();
		}
		return "Client not found";
	}
	
	

}
