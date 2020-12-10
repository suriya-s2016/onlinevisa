package com.cg.vms.exception;

@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception {

	public AccountNotFoundException(String message)
	{
		super(message);
	}
}
