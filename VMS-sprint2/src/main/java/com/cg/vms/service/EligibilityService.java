package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.model.Client;
import com.cg.vms.model.Eligibility;
import com.cg.vms.repository.ClientRepository;
import com.cg.vms.repository.EligibilityRepository;



@Service
public class EligibilityService {

	@Autowired
	private EligibilityRepository eligibilityRepo;
	@Autowired
	private ClientRepository clientRepo;
	
	
	
    // For inserting data	
	public Eligibility insertData(Eligibility eligibility) {
		
		return eligibilityRepo.save(eligibility);
		
	}
	
    // View all the Details	
	public List<Eligibility> getAllEligibilityDetails() {
		
		return eligibilityRepo.findAll();
		
	}
	
    // View Data by Country Code	
	public Optional<Eligibility> viewData(String code){
		
		return eligibilityRepo.findById(code);
		
	}
	
    // Delete Data	
	public void deleteData(Eligibility eligibility) {
		
		eligibilityRepo.delete(eligibility);
		
	}
	
	
	public void checkEligibility(long clientId) {
		Optional<Client> c=clientRepo.findById(clientId);
	    Client c1=c.get();
		String country=c1.getCountry();
		String qualify=c1.getQualification();
		
		Optional<Eligibility> e=eligibilityRepo.findById(country);
		Eligibility el = e.get();
		if(qualify.equalsIgnoreCase(el.getEducationParameter())) {
			c1.setStatus("Eligibility Verified");
	       clientRepo.save(c1);
		}
		else {
			c1.setStatus("Not Eligible");
	       clientRepo.save(c1);
		}
	}
}
	
	

	
	


