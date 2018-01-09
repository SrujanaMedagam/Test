package com.valuelabs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.model.AccountTransactionDetails;

@Repository
@Transactional
public class DepositAndWithdrawDaoImpl implements DepositAndWithdrawDao {
	@Autowired(required = true)
	HibernateTemplate hibernateTemplate;
	@Autowired(required = true)
	AccountTransactionDetails accountTransactionDetails;

	@SuppressWarnings("unchecked")
	@Override
	public List<String> depositAccNumber(String accountNumber) {
		String hql = "select acc.AccNumber from AccountDetails acc where acc.AccNumber= ?";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public boolean depositAccNumber(Double amount, String accountNumber) {
		String hql = "UPDATE AccountDetails set totalAmount = totalAmount + ? WHERE AccNumber=?";
		int result = hibernateTemplate.bulkUpdate(hql, amount, accountNumber);
		return true;
	}

	@Override
	public boolean withdrawAccNumber(String accountNumber, Double amount) {
		String hql = "UPDATE AccountDetails set totalAmount = totalAmount - ? WHERE AccNumber=?";
		int result = hibernateTemplate.bulkUpdate(hql, amount, accountNumber);
		return true;
	}

	@Override
	public List isAmountAvailable(String accountNumber) {
		String hql = "select acc.totalAmount from AccountDetails acc where acc.AccNumber=?";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public List withdrawAccNumber(String accountNumber) {
		String hql = "select acc.AccNumber from AccountDetails acc where acc.AccNumber=?";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public boolean depostAndWithdrawAmountToTransactionHistory(
			AccountTransactionDetailsBean accountTransactionDetailsBean) {
		accountTransactionDetails.setAccountNumber(accountTransactionDetailsBean.getAccountNumber());
		accountTransactionDetails.setTransactionDate(new java.sql.Date(new java.util.Date().getTime()));
		accountTransactionDetails.setAmount(accountTransactionDetailsBean.getAmount());
		accountTransactionDetails.setTransactionType(accountTransactionDetailsBean.getTransactionType());
		accountTransactionDetails.setBalanceAmount(accountTransactionDetailsBean.getBalanceAmount());
		accountTransactionDetails.setToAccount(accountTransactionDetailsBean.getToAccount());
		accountTransactionDetails.setRemarks(accountTransactionDetailsBean.getRemarks());
		hibernateTemplate.save(accountTransactionDetails);
		return true;
	}

	@Override
	public List balanceAmountAfterDeposit(String accountNumber) {
		String hql = " select acc.totalAmount from AccountDetails acc where acc.AccNumber= ? ";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public List<String> balanceAmountAfterWithdraw(String accountNumber) {
		String hql = "select acc.totalAmount from AccountDetails acc where acc.AccNumber=?";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public List<String> getEmail(String accountNumber) {
		String hql = "select ld.emailId from LoginDetails ld where ld.accountNumber=?";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}
}
