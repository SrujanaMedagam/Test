package com.valuelabs.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.stereotype.Service;
@Entity
@Table(name="AccountTransactionDetails")
@SecondaryTable(name="AccountTransactionDetails2222")
@Service("accountTransactionDetails")
public class AccountTransactionDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2640789003009329326L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Sno=1;
	@Column
	private String accountNumber;
	@Column
	private Date transactionDate;
	@Column
	private double amount;
	@Column
	private String transactionType;
	@Column
	private String toAccount;
	@Column
	private double BalanceAmount;
	@Column
	private String Remarks ;
	
	
	public int getSno() {
		return Sno;
	}
	public void setSno(int sno) {
		Sno = sno;
	}
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date Date) {
		this.transactionDate = Date;
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
	
	
}
