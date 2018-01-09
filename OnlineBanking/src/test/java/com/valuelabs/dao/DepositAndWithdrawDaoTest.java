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

import com.valuelabs.config.TestDepostAndWithdrawDao;
import com.valuelabs.model.AccountDetails;
import com.valuelabs.model.AccountTransactionDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDepostAndWithdrawDao.class})
@WebAppConfiguration
public class DepositAndWithdrawDaoTest {
	@Autowired
	@Qualifier("depositAndWithdrawDaoMock")
	DepositAndWithdrawDao depositAndWithdrawDao;
	
	@Autowired(required = true)
	AccountDetails accountDetails; 
	
	@Autowired(required = true)
	AccountTransactionDetails accountTransactionDetails; 
	
	@Autowired
	@Qualifier("hibernateTemplateInstance")
	HibernateTemplate hibernateTemplate;
	
	@Before
    public void setUp() {
		List list=new ArrayList<>();
		list.add("2");
		List list1=new ArrayList<>();
		list1.add("2");
		list1.add(10000.00);
		String hql="select acc.AccNumber from AccountDetails acc where acc.AccNumber= ?";
		Mockito.when(hibernateTemplate.find(hql,"2")).thenReturn(list);
		/*String hql1= " select acc.totalAmount from AccountDetails acc where acc.AccNumber= ? ";
		Mockito.when(hibernateTemplate.find(hql,"2")).thenReturn(list);*/
		
    }
	
	@Test
	public void depositMoneyToAccount()
	{
		String  AccountNumber = null;
		List check=depositAndWithdrawDao.depositAccNumber("2");
		Iterator it = check.iterator();
		while(it.hasNext()){
			 AccountNumber = (String) it.next();
			 System.out.println("AccountNumber:::::"+AccountNumber);
		}
		assertEquals("2", AccountNumber);
		
	}
	@Test
	public void withdrawMoneyFromAccount()
	{
		String  AccountNumber = null;
		List check=depositAndWithdrawDao.depositAccNumber("2");
		Iterator it = check.iterator();
		while(it.hasNext()){
			 AccountNumber = (String) it.next();
			 System.out.println("AccountNumber:::::"+AccountNumber);
		}
		assertEquals("2", AccountNumber);
		
	}
	
}
