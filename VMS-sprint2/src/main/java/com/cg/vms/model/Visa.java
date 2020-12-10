package com.cg.vms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component 
@Entity
public class Visa {
	@Id
	private int visaId;  //visa attributes
	private String visaName;
	private int period;
	private double processingFee;
	public Visa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Visa(int visaId, String visaName, int period, double processingFee) {
		super();
		this.visaId = visaId;
		this.visaName = visaName;
		this.period = period;
		this.processingFee = processingFee;
	}
	public int getVisaId() {  //generating getters and setters for visa attributes
		return visaId;
	}
	public void setVisaId(int visaId) {
		this.visaId = visaId;
	}
	public String getVisaName() {
		return visaName;
	}
	public void setVisaName(String visaName) {
		this.visaName = visaName;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public double getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(double processingFee) {
		this.processingFee = processingFee;
	}
	@Override
	public String toString() { //generating string to string method
		return "Visa [visaId=" + visaId + ", visaName=" + visaName + ", period=" + period + ", processingFee="
				+ processingFee + "]";
	}
	

}
