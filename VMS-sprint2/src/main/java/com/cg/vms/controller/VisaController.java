package com.cg.vms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.exception.VisaNotFoundException;
import com.cg.vms.model.Visa;
import com.cg.vms.service.VisaService;

@RestController
public class VisaController {
	@Autowired
	private VisaService visaservice;
	
	@PostMapping("/visa/newvisa") //creating new visa
	public Visa createVisa(@RequestBody Visa visa)
	{
		return visaservice.createVisa(visa);
	}
	
	@GetMapping("/visa/all") //retreving visa details
	public List<Visa> getAllvisa(){
		return visaservice.getAllVisa();
		
	}
	
	@GetMapping("/visa/{id}") //retreving visa details using id
	public ResponseEntity<Visa> getVisaById(@PathVariable(value= "id") Integer visaId) throws VisaNotFoundException 
	{
		Visa visa= visaservice.getVisaById(visaId).orElseThrow(()-> new VisaNotFoundException("No Visa Found With this Id : "+visaId));
		return ResponseEntity.ok().body(visa);
	}
	
	

}
