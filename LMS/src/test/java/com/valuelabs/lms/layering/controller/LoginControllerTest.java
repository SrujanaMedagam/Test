package com.valuelabs.lms.layering.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.valuelabs.lms.configuration.LmsConfiguration;
import com.valuelabs.lms.configuration.LmsInitializer;
import com.valuelabs.lms.configuration.test.TestContextController;
import com.valuelabs.lms.service.LoginService;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContextController.class})
@WebAppConfiguration
public class LoginControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	@Qualifier("loginServiceMock")
	private LoginService empinfo;
	
	 @Autowired
	 private WebApplicationContext webApplicationContext;
	 
	    @Before
	    public void setUp() {
	        //We have to reset our mock between tests because the mock objects
	        //are managed by the Spring container. If we would not reset them,
	        //stubbing and verified behavior would "leak" from one test to another.
	      //  Mockito.reset(empinfo);
	   	
	        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	        Mockito.reset(empinfo);
	      Mockito.when(empinfo.checkEmployeeLoginCredentials("vlsp2577","rahul1234","Employee")).thenReturn(true);
	    }
	@Test
	public void testHandleLogin() throws Exception 
	{
	
mockMvc.perform(get("/login/userlogin").param("uname", "vlsp2577").param("pass", "rahul1234").param("role", "Employee"))
        .andExpect(status().isOk())
        .andExpect(content().string("passed"));
	
	}
}
