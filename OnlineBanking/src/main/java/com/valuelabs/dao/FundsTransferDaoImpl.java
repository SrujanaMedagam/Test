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
public class FundsTransferDaoImpl implements FundsTransferDao {
	@Autowired(required = true)
	AccountTransactionDetails accountTransactionDetails;
	@Autowired(required = true)
	AccountTransactionDetailsBean accountTransactionDetailsBean;
	@Autowired(required = true)
	HibernateTemplate hibernateTemplate;

	@Override
	public boolean trnsferFunds(Double amount, String accountDetails) {
		String hql = "UPDATE AccountDetails acc set acc.totalAmount = acc.totalAmount - ? WHERE acc.AccNumber = ? ";
		int result = hibernateTemplate.bulkUpdate(hql, amount, accountDetails);
		return true;
	}

	@Override
	public List checkAmount(String accountDetails) {
		String hql = " select acc.totalAmount from AccountDetails acc where acc.AccNumber = ? ";
		return (List) hibernateTemplate.find(hql, accountDetails);
	}

	@Override
	public boolean trnsferFundsUpdate(Double amount, String accountNumber) {
		String hql = " UPDATE AccountDetails acc set acc.totalAmount = acc.totalAmount + ? WHERE acc.AccNumber = ? ";
		int result = hibernateTemplate.bulkUpdate(hql, amount, accountNumber);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<String> balanceAmountAfterTransferFunds(String accountDetails) {
		String hql = " select acc.totalAmount from AccountDetails acc where acc.AccNumber= ?";
		return (List<String>) hibernateTemplate.find(hql, accountDetails);
	}

	@SuppressWarnings("unchecked")
	public List<String> totalAmountAfterTransferFunds(String accountNumber) {
		String hql = " select acc.totalAmount from AccountDetails acc where acc.AccNumber = ? ";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public boolean transferFundsToTransactionHistory(AccountTransactionDetailsBean accountTransactionDetailsBean) {
		accountTransactionDetails.setAccountNumber(accountTransactionDetailsBean.getAccountNumber());
		accountTransactionDetails.setToAccount(accountTransactionDetailsBean.getToAccount());
		accountTransactionDetails.setTransactionDate(new java.sql.Date(new java.util.Date().getTime()));
		accountTransactionDetails.setAmount(accountTransactionDetailsBean.getAmount());
		accountTransactionDetails.setTransactionType(accountTransactionDetailsBean.getTransactionType());
		accountTransactionDetails.setBalanceAmount(accountTransactionDetailsBean.getBalanceAmount());
		accountTransactionDetails.setRemarks(accountTransactionDetailsBean.getRemarks());
		hibernateTemplate.save(accountTransactionDetails);
		return true;
	}

	@Override
	public boolean updatedTransferFundsToTransactionHistory(
			AccountTransactionDetailsBean accountTransactionDetailsBean) {
		accountTransactionDetails.setAccountNumber(accountTransactionDetailsBean.getAccountNumber());
		accountTransactionDetails.setToAccount(accountTransactionDetailsBean.getToAccount());
		accountTransactionDetails.setTransactionDate(new java.sql.Date(new java.util.Date().getTime()));
		accountTransactionDetails.setAmount(accountTransactionDetailsBean.getAmount());
		accountTransactionDetails.setTransactionType(accountTransactionDetailsBean.getTransactionType());
		accountTransactionDetails.setBalanceAmount(accountTransactionDetailsBean.getBalanceAmount());
		accountTransactionDetails.setRemarks(accountTransactionDetailsBean.getRemarks());
		hibernateTemplate.save(accountTransactionDetails);
		return true;
	}

}
