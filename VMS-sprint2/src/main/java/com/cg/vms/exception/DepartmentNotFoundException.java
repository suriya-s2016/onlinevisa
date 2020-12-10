package com.cg.vms.exception;
//------------------------ 1. OnlineVisaManagement Application --------------------------
/**********************************************
* 
*        -author      :      suriyaS
* 
*/
public class DepartmentNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public DepartmentNotFoundException(String message) {
		super(message);
	}

}
