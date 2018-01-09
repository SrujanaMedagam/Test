package com.valuelabs.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.valuelabs.config.TestFundsTransrferController;
import com.valuelabs.service.FundsTransferService;
import com.valuelabs.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestFundsTransrferController.class })
@WebAppConfiguration
public class FundsTransferControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired(required = true)
	@Qualifier("fundsTransferService")
	private FundsTransferService fundsTransferService;

	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;

	@Before
	public void setUp() {

		Mockito.reset(fundsTransferService);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String accountNumber = "2";
		Mockito.when(loginService.checkUserAccountNumber("2", "2")).thenReturn("2");
		Mockito.when(fundsTransferService.trnsferFunds("2", 5000.00)).thenReturn(true);
		Mockito.when(fundsTransferService.trnsferFundsUpdate("2", 5000.00)).thenReturn(true);
		Double balanceAmount = 10000.00;
		Mockito.when(fundsTransferService.balanceAmountAfterTransferFunds("2")).thenReturn(balanceAmount);
		fundsTransferService.transferFundsToTransactionHistory("2", "1", 5000.00,  "savings", 10000.00,
				"remarks");
		Mockito.when(fundsTransferService.totalAmountAfterTransferFunds("1")).thenReturn(balanceAmount);
		Mockito.when(fundsTransferService.updatedTransferFundsToTransactionHistory("1", "2", 5000.00, 
				"savings", 10000.00, "remarks")).thenReturn(true);
	}

	@Test
	public void testFundsTransfer() throws Exception {
		mockMvc.perform(get("/funds/transfer").param("username", "2").param("password", "2").param("accountNumber", "2")
				.param("amount", "5000.00").param("transactionDate", "15/03/2016").param("remarks", "jdfskldfj"))
				.andExpect(status().isOk()).andExpect(content().string("passed"));

	}

}
