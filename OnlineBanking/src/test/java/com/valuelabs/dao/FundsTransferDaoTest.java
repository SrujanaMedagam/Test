package com.valuelabs.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.config.TestFundsTransferDao;
import com.valuelabs.model.AccountTransactionDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestFundsTransferDao.class })
@WebAppConfiguration
public class FundsTransferDaoTest {

	@Autowired(required = true)
	@Qualifier("fundsTransferDaoMock")
	FundsTransferDao fundsTransferDao;

	@Autowired(required = true)
	AccountTransactionDetails accountTransactionDetails;

	@Autowired(required = true)
	AccountTransactionDetailsBean accountTransactionDetailsBean;

	@Autowired(required = true)
	@Qualifier("hibernateTemplateInstance")
	HibernateTemplate hibernateTemplate;

	@Before
	public void setUp() {
		List list = new ArrayList<>();
		list.add("2");
		List list1 = new ArrayList<>();
		list1.add("2");
		list1.add(10000.00);
		String hql = " select acc.totalAmount from AccountDetails acc where acc.AccNumber = ?";
		Mockito.when(hibernateTemplate.find(hql, "2")).thenReturn(list);
		/*
		 * String hql1= " select acc.totalAmount from AccountDetails acc where acc.AccNumber= ? "
		 * ; Mockito.when(hibernateTemplate.find(hql,"2")).thenReturn(list);
		 */
	}

	@Test
	public void fundsTransferToAccount() {
		double amount = 0;
		List check = fundsTransferDao.checkAmount("2");
		Iterator it = check.iterator();
		while (it.hasNext()) {
			amount = (double) it.next();
			System.out.println("AccountNumber:::::" + amount);
		}
		assertEquals("2", amount);
	}
}
