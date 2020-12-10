package com.cg.vms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.exception.EligibilityNotFoundException;
import com.cg.vms.model.Eligibility;
import com.cg.vms.service.EligibilityService;

@RestController
public class EligibilityController {

	@Autowired
	private EligibilityService service;
	
	
	@PostMapping("/eligibility/add")
	public Eligibility insertData(@RequestBody Eligibility eligibility) {
		
		return service.insertData(eligibility);
		
	}
	
	@GetMapping("/eligibility/all")
	public List<Eligibility> getAllEligibilityDetails(){
		
		return service.getAllEligibilityDetails();
	}
	
	
	@GetMapping("/eligibility/{code}")
	public ResponseEntity<Eligibility> viewData(@PathVariable(value= "code") String code) throws EligibilityNotFoundException{
		
		Eligibility eligibility= service.viewData(code).orElseThrow(() -> new EligibilityNotFoundException("No Eligibility Details Found With this country code : "+code));
	    return ResponseEntity.ok().body(eligibility);
	}
	
	
	
	@DeleteMapping("/eligibility/delete/{code}")
	public String deleteData(@PathVariable(value= "code") String code) throws EligibilityNotFoundException{
		
		Eligibility eligibility=service.viewData(code).orElseThrow(() -> new EligibilityNotFoundException("No Eligibility Details Found With this country code : "+code));
	    service.deleteData(eligibility);
	    return "Eligibility details deleted succesfully"; 
	}
	
	@PostMapping("/eligibility/checkeligibility/{clientId}")
	public String checkEligibility(@PathVariable(value= "clientId") long clientId) throws NoSuchElementException {
		try {
		service.checkEligibility(clientId);
		return "Client Status updated";
		}
		catch(NoSuchElementException e) {
			return "No Client with the given client id.";
		}
	}
	
	
	
}
