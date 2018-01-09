package com.valuelabs.service;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.dao.DepositAndWithdrawDao;

@Service("depositAndWithdrawService")
public class DepositAndWithdrawServiceImpl implements DepositAndWithdrawService {
	@Autowired(required = true)
	DepositAndWithdrawDao depositAndWithdrawDao;
	@Autowired(required = true)
	AccountTransactionDetailsBean accountTransactionDetailsBean;

	@Override
	@Transactional
	public String depositAmount(String accountNumber) {
		String result;
		List listofAccounts = depositAndWithdrawDao.depositAccNumber(accountNumber);
		if (listofAccounts.contains(accountNumber)) {
			result = accountNumber;
		} else {
			result = "";
		}
		return result;
	}

	@Override
	public boolean depositAmount(String accountNumber, Double amount) {
		return depositAndWithdrawDao.depositAccNumber(amount, accountNumber);
	}

	@Override
	public String withdrawAmount(String accountNumber) {
		List listofAccounts = depositAndWithdrawDao.withdrawAccNumber(accountNumber);
		/*
		 * if (listofAccounts.contains(accountNumber)) { }
		 */
		return accountNumber;
	}

	public boolean withdrawAmount(String accountNumber, Double amount) {
		String result;
		double totalAmount = 0;
		List list = depositAndWithdrawDao.isAmountAvailable(accountNumber);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			totalAmount = (double) it.next();
		}
		if (totalAmount >= amount) {
			depositAndWithdrawDao.withdrawAccNumber(accountNumber, amount);
			return true;
		}
		return false;
	}

	public String depositAndWithdrawAmountToTransactionHistory(String accountNumber, Double amount,
			 String transactionType, Double balanceAmount, String toAccount, String remarks) {
		String result;
		accountTransactionDetailsBean.setAccountNumber(accountNumber);
		accountTransactionDetailsBean.setTransactionDate(new java.sql.Date(new java.util.Date().getTime()));
		System.out.println(new java.sql.Date(new java.util.Date().getTime()));
		accountTransactionDetailsBean.setAmount(amount);
		accountTransactionDetailsBean.setTransactionType(transactionType);
		accountTransactionDetailsBean.setBalanceAmount(balanceAmount);
		accountTransactionDetailsBean.setToAccount(toAccount);
		accountTransactionDetailsBean.setRemarks(remarks);
		if (depositAndWithdrawDao.depostAndWithdrawAmountToTransactionHistory(accountTransactionDetailsBean)) {
			result = "passed";
		}else{
			result = "failed";
		}
		return result;
	}

	@Override
	public double balanceAmountAfterDeposit(String accountNumber) {
		double totalAmount = 0;
		List list = depositAndWithdrawDao.balanceAmountAfterDeposit(accountNumber);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			totalAmount = (double) iterator.next();
		}
		return totalAmount;
	}

	@Override
	public double balanceAmountAfterWithdraw(String accountNumber) {
		double totalAmount = 0;
		List list = depositAndWithdrawDao.balanceAmountAfterWithdraw(accountNumber);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			totalAmount = (double) iterator.next();
		}
		return totalAmount;
	}
	@Override
	public String getEmail(String accountNumber){
		String emailId = null;
		List list = depositAndWithdrawDao.getEmail(accountNumber);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			 emailId = (String) iterator.next();
		}
		return emailId;
	}
}
