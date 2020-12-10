package com.cg.vms.service;

import com.cg.vms.exception.UserNotFoundException;
import com.cg.vms.model.Client;

public interface ClientService {
	public Client applyVisa(Client client);

	public String visaStatus(Long clientId) throws UserNotFoundException;
}
