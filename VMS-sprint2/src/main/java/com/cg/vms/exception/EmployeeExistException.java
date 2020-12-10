package com.cg.vms.exception;
//------------------------ 1. StockExchangeManagement Application --------------------------
/**********************************************
* 
*        -author      :      suriyaS
* 
*/
public class EmployeeExistException extends Exception{
	private static final long serialVersionUID = 1L;
	public EmployeeExistException(String message) {
		super(message);
	}
	

}
