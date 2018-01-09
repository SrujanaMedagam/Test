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
import com.valuelabs.config.TestContextService;
import com.valuelabs.dao.LoginDao;
import com.valuelabs.model.LoginDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextService.class})
@WebAppConfiguration
public class LoginServiceTest {
	
	@Autowired
	@Qualifier("loginServiceInstance")
	private LoginService loginService;
	
	@Autowired
	@Qualifier("loginDaoMock")
	private LoginDao loginDao;
	
	@Before
    public void setUp() {
		List<String> list=new ArrayList<String>();
		LoginDetails loginDetails= new LoginDetails();
		loginDetails.setAccountNumber("2");
		//list.add("employee");
		Mockito.when(loginDao.checkLoginCredentials("2", "2")).thenReturn(list);
    }
	@Test
	public void checkEmployeeLoginCredentials()
	{
		boolean check=loginService.checkUserLoginCredentials("2","2");
		assertEquals(true, check);
	}

}
