package com.valuelabs.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.config.TestFundsTransferService;
import com.valuelabs.dao.FundsTransferDao;
import com.valuelabs.model.AccountDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestFundsTransferService.class })
@WebAppConfiguration
public class FundsTransferServiceTest {
	
	@Autowired(required = true)
	@Qualifier("fundsTransferService")
	private FundsTransferService fundsTransferService;

	@Autowired(required = true)
	@Qualifier("fundsTransferDaoMock")
	FundsTransferDao fundsTransferDao;

	@Autowired(required = true)
	AccountTransactionDetailsBean accountTransactionDetailsBean;

	@Before 
	public void setUp() {
		List<Double> list=new ArrayList<Double>();
		AccountDetails accountDetails= new AccountDetails();
		accountDetails.setTotalAmount(5000.00);
		list.add(5000.00);
		//Mockito.when(fundsTransferDao.checkAmount("2").thenReturn(list);
	}

	@Test
	public void testTrnsferFunds() {
		boolean value = fundsTransferService.trnsferFunds("2", 2000.00);
		assertEquals(false, value);
	}
}
