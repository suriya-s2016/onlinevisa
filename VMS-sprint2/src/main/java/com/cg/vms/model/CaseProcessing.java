package com.cg.vms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CaseProcessing {
	public static final String set = null;
	
	@Id
	private int clientId;
	private String ProcessingStatus;
	
	
	public CaseProcessing() {
		super();
	}
	
	
	public CaseProcessing(int clientId, String processingStatus) {
		super();
		this.clientId = clientId;
		ProcessingStatus = processingStatus;
	}


	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getProcessingStatus() {
		return ProcessingStatus;
	}
	public void setProcessingStatus(String processingStatus) {
		ProcessingStatus = processingStatus;
	}


	@Override
	public String toString() {
		return "CaseProcessing [clientId=" + clientId + ", ProcessingStatus=" + ProcessingStatus + "]";
	}
	
	
}