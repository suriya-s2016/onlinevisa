package com.cg.vms.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.model.CaseProcessing;
import com.cg.vms.model.Client;
import com.cg.vms.repository.ClientRepository;
import com.cg.vms.service.ProcessingService;

@RestController
@RequestMapping("/processing")
public class ProcessingController {
	
	@Autowired
	ProcessingService processsingRepository;
	@Autowired
	ClientRepository clientRepo;
	@Autowired
	private JavaMailSender jms;
	@GetMapping("all")
	public List<CaseProcessing> findAll(){
	return processsingRepository.getAllCaseProcessing();	
	}
	
	@GetMapping("/{clientId}")
	public CaseProcessing find(@PathVariable int clientId) {
		Optional<CaseProcessing> proOptional=processsingRepository.getCaseProcessing(clientId);
		return proOptional.orElse(null);
	}
	@PostMapping("/add")
	public CaseProcessing add(@RequestBody CaseProcessing processing) {
		CaseProcessing resPro=processsingRepository.saveCaseProcessing (processing);
		return resPro;
	}
	
	@PutMapping("/update")
	public CaseProcessing update(@RequestBody CaseProcessing processing) {
		Optional<CaseProcessing> empOptional=processsingRepository.getCaseProcessing(processing.getClientId());
		if(empOptional.isPresent()) {
		return processsingRepository.saveCaseProcessing(processing);
	}
		else {
			return null;
		}
	}
	

	@DeleteMapping("/{clientId}")
	public void delete(@PathVariable int clientId) {
		processsingRepository.deleteCaseProcessing(clientId);
}
	@GetMapping("/verifyclient/{clientId}")
	public String visaApproveMail(@PathVariable(value= "clientId") Long clientId) throws NoSuchElementException
	{
	boolean verifiedOrNot =processsingRepository.visaApproveMail(clientId);
	if(verifiedOrNot)
	{
	Optional<Client> c=clientRepo.findById(clientId);
	Client c1=c.get();
	SimpleMailMessage mail=new SimpleMailMessage();
	mail.setTo("suriyas2016@gmail.com");
	mail.setSubject("Visa Application Status");
	mail.setText("Hello Sir Client Id :"+c1.getClientId()+", Your Visa has been Approved.\n Thanks & Regards\n Suriya\n NSPAR LTD");
	jms.send(mail);
	return "Client Visa is approved and Mail has been sent";
	}
	return "Client Visa is rejected"; 
	}
}

