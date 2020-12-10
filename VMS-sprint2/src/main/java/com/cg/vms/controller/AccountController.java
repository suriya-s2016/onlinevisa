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

import com.cg.vms.exception.AccountNotFoundException;
import com.cg.vms.model.Account;
import com.cg.vms.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService service;
	
	
	@PostMapping("/account/add")
	public Account insertData(@RequestBody Account account) {
		
		return service.insertData(account);
		
	}
	
	@GetMapping("/account/all")
	public List<Account> viewAllAccounts(){
		
		return service.viewAllAccounts();
	}
	
	
	@GetMapping("/account/{clientId}")
	public ResponseEntity<Account> viewAccount(@PathVariable(value= "clientId") Long clientId) throws AccountNotFoundException{
		
		Account account= service.viewAccount(clientId).orElseThrow(() -> new AccountNotFoundException("No Account Details Found With this Client ID : "+clientId));
	    return ResponseEntity.ok().body(account);
	}
	
	
	@DeleteMapping("/account/delete/{clientId}")
	public String deleteAccount(@PathVariable(value= "clientId") Long clientId) throws AccountNotFoundException{
		
		Account account=service.viewAccount(clientId).orElseThrow(() -> new AccountNotFoundException("No Account Details Found With this Client ID : "+clientId));
	    service.deleteAccount(account);
	    return "Account details deleted succesfully"; 
	}
	
	
	@PostMapping("/account/updatestatus/{clientId}")
	public String updateStatus(@PathVariable(value= "clientId") Long clientId)  throws AccountNotFoundException{
		service.viewAccount(clientId).orElseThrow(() -> new AccountNotFoundException("No Account Details Found With this Client ID : "+clientId));
		service.updateStatus(clientId);
		return "Status Updated!!";
	}
	
	@PostMapping("/account/verifyclient/{clientId}")
	public String verifyClient(@PathVariable(value= "clientId") Long clientId) throws NoSuchElementException {
		try {
		service.verifyClient(clientId);
		return "Verified By Accounts.";
		}
		catch(NoSuchElementException e) {
			return "No Client with the given client id.";
		}
		
	}
	
	
}
