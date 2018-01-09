package com.valuelabs.lms.layering.service;

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

import com.valuelabs.lms.configuration.test.TestContextService;
import com.valuelabs.lms.dao.LoginDao;
import com.valuelabs.lms.model.AdminPermission;
import com.valuelabs.lms.service.LoginService;

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
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
    //    Mockito.reset(todoServiceMock);
		List<String> list=new ArrayList<String>();
		AdminPermission adminPermission= new AdminPermission();
		adminPermission.setRole("employee");
		list.add("employee");
		
		Mockito.when(loginDao.checkLoginCredentials("vlsp2577", "rahul1234")).thenReturn(list);
		
    }
	@Test
	public void checkEmployeeLoginCredentials()
	{
		
	//	List<AdminPermission> list1=loginDao.checkLoginCredentials("vlsp2577", "rahul1234");
		boolean check=loginService.checkEmployeeLoginCredentials("vlsp2577","rahul1234", "employee");
		//assertEquals("vlsp2577", list1.get(0).getEmpId());
		assertEquals(true, check);
		
	}

}
