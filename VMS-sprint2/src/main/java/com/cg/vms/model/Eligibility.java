package com.cg.vms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Eligibility {
	
	@Id
	private String code;
	private String countryName;
	private String languageParameter;
	private String educationParameter;
	
	
	// No parameter Constructor
	public Eligibility() {
		super();
	}
	
	

	public Eligibility(String code, String countryName, String languageParameter, String educationParameter) {
		super();
		this.code = code;
		this.countryName = countryName;
		this.languageParameter = languageParameter;
		this.educationParameter = educationParameter;
	}



	// Getters and Setters
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public String getLanguageParameter() {
		return languageParameter;
	}


	public void setLanguageParameter(String languageParameter) {
		this.languageParameter = languageParameter;
	}


	public String getEducationParameter() {
		return educationParameter;
	}


	public void setEducationParameter(String educationParameter) {
		this.educationParameter = educationParameter;
	}


    // toString() method
	@Override
	public String toString() {
		return "Eligibility [code=" + code + ", countryName=" + countryName + ", languageParameter=" + languageParameter
				+ ", educationParameter=" + educationParameter + "]";
	}
	
	
	
	
	
	
	
	


	


	

}
