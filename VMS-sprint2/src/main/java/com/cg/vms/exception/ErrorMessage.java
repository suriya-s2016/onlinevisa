package com.cg.vms.exception;

import java.util.Date;
//------------------------ 1. OnlineVisaManagement Application --------------------------
/**********************************************
* 
*        -author      :      suriyaS
*        -class       :      ErrorMessage
*        -description :      This class holds errorCode ,errorMessage and date of the exception 
* 
*/
public class ErrorMessage {
private int errorCode;
private String errorMessage;
private Date date;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getErrorCode() {
	return errorCode;
}
public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}

}
