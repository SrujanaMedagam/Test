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
import com.valuelabs.config.TestContextDao;
import com.valuelabs.dao.LoginDao;
import com.valuelabs.model.AccountDetails;
import com.valuelabs.model.LoginDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextDao.class})
@WebAppConfiguration
public class LoginDaoTest {
	
	@Autowired
	@Qualifier("loginDaoInstance")
	LoginDao loginDaoInstance;
	
	@Autowired(required = true)
	AccountDetails accountDetails; 
	
	@Autowired(required = true)
	LoginDetails loginDetails;	
	
	@Autowired
	@Qualifier("hibernateTemplateInstance")
	HibernateTemplate hibernateTemplate;
	
	
	@SuppressWarnings("unchecked")
	@Before
	
    public void setUp() {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
    //    Mockito.reset(todoServiceMock);
		@SuppressWarnings("rawtypes")
		List list=new ArrayList<>();
		list.add("2");
		String hql="Select user.accountNumber from LoginDetails user where user.username=? and user.password=?";
		Mockito.when(hibernateTemplate.find(hql,"2", "2")).thenReturn(list);
    }
	@Test
	public void checkEmployeeLoginCredentials()
	{
		String  AccountNumber = null;
		@SuppressWarnings("unchecked")
		List check=loginDaoInstance.checkLoginCredentials("2", "2");
		Iterator it = check.iterator();
		while(it.hasNext()){
			 AccountNumber = (String) it.next();
			 System.out.println("AccountNumber::"+AccountNumber);
		}
		assertEquals("2", AccountNumber);
		
	}
}
