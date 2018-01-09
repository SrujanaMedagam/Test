package com.valuelabs.service;

public interface DepositAndWithdrawService {
	public String depositAmount(String accountNumber);
	public boolean depositAmount(String accountNumber,Double amount);
	public String withdrawAmount(String accountNumber);
	public boolean withdrawAmount(String accountNumber,Double amount);
	public String depositAndWithdrawAmountToTransactionHistory(String accountNumber, Double amount,String transactionType,Double balanceAmount,String toAccount,String remarks);
	public double balanceAmountAfterDeposit(String accountNumber);
	public double balanceAmountAfterWithdraw(String accountNumber);
	public String getEmail(String accountNumber);
	

}
