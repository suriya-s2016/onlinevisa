package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.model.Visa;
import com.cg.vms.repository.VisaRepository;

@Service  //specialized components
public class VisaService {
	
	
	@Autowired 
	private VisaRepository VisaRepo;
	
	public Visa createVisa(Visa visa) //This service Provides service for create of visa details and add to visa table
	{
		return VisaRepo.save(visa);
	}
	public List<Visa>  getAllVisa() //This service used to show all the visa data which was created
	{
		return VisaRepo.findAll();
	}
	public Optional<Visa> getVisaById(int id) //This service used to show the visa details by Id
	{
		return VisaRepo.findById(id);
	}

}
