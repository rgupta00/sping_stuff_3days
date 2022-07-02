package com.customer.dto;

public class CustomerData {

	private String emailId;
	private String name;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CustomerData(String emailId, String name) {
		super();
		this.emailId = emailId;
		this.name = name;
	}
	public CustomerData() {}
	@Override
	public String toString() {
		return "CustomerData [emailId=" + emailId + ", name=" + name + "]";
	}
	
	
}
