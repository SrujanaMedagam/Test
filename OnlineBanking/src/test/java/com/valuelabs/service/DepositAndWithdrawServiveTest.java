package com.valuelabs.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.config.TestDepositAndWithdrawService;
import com.valuelabs.dao.DepositAndWithdrawDao;
import com.valuelabs.model.AccountDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDepositAndWithdrawService.class})
@WebAppConfiguration
public class DepositAndWithdrawServiveTest {
	

	@Autowired
	@Qualifier("depositAndWithdrawService")
	private DepositAndWithdrawService depositAndWithdrawService;
	
	@Autowired(required = true)
	@Qualifier("depositAndWithdrawDaoMock")
	DepositAndWithdrawDao depositAndWithdrawDao;
	
	@Autowired(required = true)
	AccountTransactionDetailsBean accountTransactionDetailsBean;

	@Before
    public void setUp() {
		List<String> list=new ArrayList<String>();
		AccountDetails accountDetails= new AccountDetails();
		accountDetails.setAccNumber("2");
		list.add("2");
		Mockito.when(depositAndWithdrawDao.depositAccNumber("2")).thenReturn(list);
		List list1=new ArrayList<Double>();
		AccountDetails accountDetails1= new AccountDetails();
		accountDetails.setTotalAmount(10000.00);
		list1.add(10000.00);
		Mockito.when(depositAndWithdrawDao.balanceAmountAfterDeposit("2")).thenReturn(list1);
		Mockito.when(depositAndWithdrawDao.depostAndWithdrawAmountToTransactionHistory(accountTransactionDetailsBean)).thenReturn(true);
		
    }
	@Test
	public void checkDepositAccountMoney()
	{
		String accountNumber=depositAndWithdrawService.depositAmount("2");
		assertEquals("2", accountNumber);
	}
	@Test
	public void checkWithdrawAccountMoney()
	{
		String accountNumber=depositAndWithdrawService.withdrawAmount("2");
		assertEquals("2", accountNumber);
	}

}
