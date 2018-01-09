package com.valuelabs.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.valuelabs.config.TestContextController;
import com.valuelabs.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestContextController.class })
@WebAppConfiguration
public class LoginControllerTest {
	
	private MockMvc mockMvc;

	@Autowired
	@Qualifier("loginServiceMock")
	private LoginService loginService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		Mockito.reset(loginService);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		Mockito.when(loginService.checkUserLoginCredentials("2", "2")).thenReturn(true);
		Mockito.when(loginService.checkIsAccountNumber("2")).thenReturn(true);
	}

	@Test
	public void testHandleLogin() throws Exception {
		String username = "2";
		String password = "2";
		mockMvc.perform(get("/login/userlogin").param("username", username).param("password",password))
		 .andExpect(status().isOk())
		 .andExpect(content().string("passed"));
			
	}
	@Test
	public void testIsAccountNumberAvailable() throws Exception {
		
		mockMvc.perform(get("/login/checkAccountNumber").param("accountNumber", "2"))
		 .andExpect(status().isOk())
		 .andExpect(content().string("passed"));
			
	}
} 
