package com.cg.vms.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Client_Table")

public class Client {
	@Id
	@Column(name = "client_id", length = 15)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clientId;
	@Column(name = "passport_number", length = 15)
	@NotNull
	private String passportNumber;
	@Column(name =  "pan_number", length = 15)
	@NotNull
	private String panNumber;
	@Column(name = "qualification", length = 15)
	@NotNull
	private String qualification;
	@Column(name = "country", length = 15)
	@NotNull
	private String country;
	@Column(name = "visa_type", length = 15)
	@NotNull
	private String typeOfVisa;
	@Column(name = "visa_status", length = 15)
	private String status;
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTypeOfVisa() {
		return typeOfVisa;
	}
	public void setTypeOfVisa(String typeOfVisa) {
		this.typeOfVisa = typeOfVisa;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Client(String passportNumber, String panNumber, String qualification, String country,
			String typeOfVisa, String status) {
		super();
		this.passportNumber = passportNumber;
		this.panNumber = panNumber;
		this.qualification = qualification;
		this.country = country;
		this.typeOfVisa = typeOfVisa;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", passportNumber=" + passportNumber + ", panNumber="
				+ panNumber + ", qualification=" + qualification + ", country=" + country + ", typeOfVisa=" + typeOfVisa
				+ ", status=" + status + "]";
	}
	
	
	
		
}
