package com.valuelabs.bean;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import io.swagger.annotations.ApiModelProperty;

@Service("fundsTransferBean")
public class FundsTransferBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty
	private String username;
	@ApiModelProperty
	private String password;
	@ApiModelProperty
	private String accountNumber;
	@ApiModelProperty
	private double amount;
	@ApiModelProperty
	private String transactionDate;
	@ApiModelProperty
	private String remarks;
	
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
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
}
