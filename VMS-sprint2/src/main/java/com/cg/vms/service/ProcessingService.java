package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;

import com.cg.vms.model.CaseProcessing;

public interface ProcessingService {
	
	public static  Client validateCase(Long clientId) {
		 return validateCase(clientId);
		 
}

	List<CaseProcessing> getAllCaseProcessing();
    Optional<CaseProcessing> getCaseProcessing(int clientId);
	CaseProcessing saveCaseProcessing(CaseProcessing processing);
	CaseProcessing editCaseProcessing(CaseProcessing processing);
	void deleteCaseProcessing(int clientId);
	public boolean visaApproveMail(Long clientId);
}
