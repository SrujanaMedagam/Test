package com.valuelabs.bean;

import org.springframework.stereotype.Service;

@Service("loginDetailsBean")
public class LoginDetailsBean {

	private String accountNumber;
	private String accountName;
	private String username;
	private String password;
	private String address;
	private String emailId;
	private int phoneNumber;
	private String panNumber;
	private int aadharNumber;
	private String accountType;
	private String accountOpenDate;
	
	private LoginDetailsBean(){
		System.out.println("Default constructor from LoginDetailsBean");
	}

	public LoginDetailsBean(String accountNumber, String accountName, String username, String password, String address,
			String emailId, int phoneNumber, String panNumber, int aadharNumber, String accountType,
			String accountOpenDate) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.accountType = accountType;
		this.accountOpenDate = accountOpenDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(String date) {
		this.accountOpenDate = date;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public int getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(int aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
