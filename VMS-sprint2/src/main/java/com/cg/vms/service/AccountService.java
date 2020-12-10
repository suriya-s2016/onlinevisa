package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.model.Account;
import com.cg.vms.model.Client;
import com.cg.vms.repository.AccountRepository;
import com.cg.vms.repository.ClientRepository;

@Service
public class AccountService {

	
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private ClientRepository clientRepo;
	
	
	// Insert Records
	public Account insertData(Account account) {
		
		return accountRepo.save(account);
	}
	
	
	// View All 
	public List<Account> viewAllAccounts() {
		return accountRepo.findAll();
	}
	
	// View Data by Client ID
	public Optional<Account> viewAccount(Long clientId) {
		return accountRepo.findById(clientId);
	}
	
    // Delete Record	
	public void deleteAccount(Account account) {
		accountRepo.delete(account);
	}
	
	//Update Payment Status
	public void updateStatus(Long clientId) {
		Optional<Account> acc=accountRepo.findById(clientId);
	    Account a=acc.get();
	    a.setPaymentStatus("PAID");
	    accountRepo.save(a);
	}
	
	
	public void verifyClient(Long clientId) {
		Optional<Client> c=clientRepo.findById(clientId);
	    Client c1=c.get();
		Optional<Account> e=accountRepo.findById(clientId);
		Account acc= e.get();
		
		String clientStatus=c1.getStatus();
		String accountStatus=acc.getPaymentStatus();
		
		if((clientStatus.equalsIgnoreCase("Eligibility Verified")) &&  (accountStatus.equalsIgnoreCase("PAID"))) {
			c1.setStatus("Account Verified");
			clientRepo.save(c1);
		}
		

	
	}
}
