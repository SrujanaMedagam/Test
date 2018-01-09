package com.valuelabs.lms.layering.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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

import com.valuelabs.lms.configuration.test.TestContextDao;
import com.valuelabs.lms.dao.LoginDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextDao.class})
@WebAppConfiguration
public class LoginDaoTest {

	
	@Autowired
	@Qualifier("hibernateTemplateInstance")
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	@Qualifier("loginDaoInstance")
	private LoginDao loginDaoInstance;
	
	@SuppressWarnings("unchecked")
	@Before
	
    public void setUp() {
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
    //    Mockito.reset(todoServiceMock);
		@SuppressWarnings("rawtypes")
		List list=new ArrayList<>();
		list.add("employee");
		String hql="Select emp.role from AdminPermission emp where emp.empId=? and emp.password=?";
		Mockito.when(hibernateTemplate.find(hql,"vlsp2577", "rahul1234")).thenReturn(list);
		
    }
	@Test
	public void checkEmployeeLoginCredentials()
	{
		
		List<String> check=loginDaoInstance.checkLoginCredentials("vlsp2577", "rahul1234");
		assertEquals("employee", check.get(0).toString());
		
	}
}
