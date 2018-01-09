package com.valuelabs.bean;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service("accountTransactionDetailsBean")
public class AccountTransactionDetailsBean {

	private int Sno = 1;

	private String accountNumber;

	private Date transactionDate;

	private double amount;

	private String transactionType;

	private String toAccount;

	private double BalanceAmount;

	private String Remarks;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date date) {
		this.transactionDate = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public double getBalanceAmount() {
		return BalanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		BalanceAmount = balanceAmount;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public int getSno() {
		return Sno;
	}

	public void setSno(int sno) {
		Sno = sno;
	}

}
