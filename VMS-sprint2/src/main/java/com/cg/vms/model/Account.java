package com.cg.vms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Account {

	
	
	    @Id
		private Long clientId;
	    private String paymentMode;
		private Double amount;
		private String paymentStatus;
		
		// No parameter Constructor
		public Account() {
			super();
		}
		
		// Getters and Setters
		public Long getClientId() {
			return clientId;
		}
		public void setClientId(Long clientId) {
			this.clientId = clientId;
		}
		public String getPaymentMode() {
			return paymentMode;
		}
		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		public String getPaymentStatus() {
			return paymentStatus;
		}
		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}
		
		
		@Override
		public String toString() {
			return "Account [clientId=" + clientId + ", paymentMode=" + paymentMode + ", Amount=" + amount
					+ ", paymentStatus=" + paymentStatus + "]";
		}
		
		
		public Account(Long clientId, String paymentMode, Double amount, String paymentStatus) {
			super();
			this.clientId = clientId;
			this.paymentMode = paymentMode;
			this.amount = amount;
			this.paymentStatus = paymentStatus;
		}
		
		
		
	
}
