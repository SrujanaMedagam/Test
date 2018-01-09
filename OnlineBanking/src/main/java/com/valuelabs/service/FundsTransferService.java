package com.valuelabs.service;

public interface FundsTransferService {
	public boolean trnsferFunds(String accountDetails,Double amount);
	public boolean trnsferFundsUpdate(String accountNumber,Double amount);
	public double balanceAmountAfterTransferFunds(String accountDetails);
	public void transferFundsToTransactionHistory(String accountDetails,String accountNumber, Double amount ,String transactionType,Double balanceAmount,String remarks);
	public double totalAmountAfterTransferFunds(String accountNumber);
	public boolean updatedTransferFundsToTransactionHistory(String accountDetails, String accountNumber, Double amount,
			String transactionType, double totalAmount,String remarks);

}
