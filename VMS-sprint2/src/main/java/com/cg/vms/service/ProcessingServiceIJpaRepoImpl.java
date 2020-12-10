
package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.model.CaseProcessing;
import com.cg.vms.model.Client;
import com.cg.vms.repository.ClientRepository;
import com.cg.vms.repository.ProcessingRepository;

@Service
public class ProcessingServiceIJpaRepoImpl implements ProcessingService {
	
	@Autowired
	private ProcessingRepository processsingRepository;
	@Autowired
	private ClientRepository clientRepo;
	@Override
	public List<CaseProcessing> getAllCaseProcessing() {
		List<CaseProcessing> allPros= processsingRepository.findAll();
		return allPros;
	}
		@Override
	public Optional<CaseProcessing> getCaseProcessing(int clientId) {
		Optional<CaseProcessing> optEmployee=processsingRepository.findById(clientId);
		return optEmployee;
	}
	@Override
	public CaseProcessing saveCaseProcessing(CaseProcessing processing) {
		CaseProcessing resPro=processsingRepository.save(processing);
		return resPro;
	}
	@Override
	public CaseProcessing editCaseProcessing(CaseProcessing processing) {
		if(processsingRepository.findById(processing.getClientId())!=null){
		return 	processsingRepository.save(processing);
		}
		else {
		return null;
	}
	}
	@Override
	public void deleteCaseProcessing(int clientId) {
		processsingRepository.deleteById(clientId);
	}
	@Override
	public boolean visaApproveMail(Long clientId) {
	Optional<Client> c=clientRepo.findById(clientId);
	Client c1=c.get();
	String clientStatus=c1.getStatus();
	if(clientStatus.equalsIgnoreCase("Account Verified")){
	c1.setStatus("Visa Approved");
	clientRepo.save(c1);
	return true;
	}
	else {
	c1.setStatus("Visa Rejected");
	return false;
	}
	}

}

