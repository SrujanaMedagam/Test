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
import com.valuelabs.config.TestDepositAndWithdrawController;
import com.valuelabs.service.DepositAndWithdrawService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestDepositAndWithdrawController.class })
@WebAppConfiguration
public class DepositAndWithdrawControllerTest {

	private MockMvc mockMvc;
	@Autowired
	@Qualifier("depositAndWithdrawService")
	private DepositAndWithdrawService depositAndWithdrawService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {

		//Mockito.reset(depositAndWithdrawService);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String accountNumber = "2";
		 Mockito.when(depositAndWithdrawService.depositAmount("2")).thenReturn(accountNumber);
		if (accountNumber != null) {
			Mockito.when(depositAndWithdrawService.depositAmount("2", 2000.00)).thenReturn(true);

			Double totalAmount = 5000.00;
			Mockito.when(depositAndWithdrawService.balanceAmountAfterDeposit("2")).thenReturn(totalAmount);
			Mockito.when(depositAndWithdrawService.depositAndWithdrawAmountToTransactionHistory("2", 2000.00,
					 "Savings", 1200.00, "_", "jdfskldfj")).thenReturn("passed");

		}
		 Mockito.when(depositAndWithdrawService.withdrawAmount("2")).thenReturn(accountNumber);
		 if(accountNumber != null){
		 Mockito.when(depositAndWithdrawService.withdrawAmount("2",2000.00)).thenReturn(true);
		 
		 double balanceAmount =15000.00;
				 Mockito.when(depositAndWithdrawService.balanceAmountAfterWithdraw("2")).thenReturn(balanceAmount);
				 Mockito.when(depositAndWithdrawService.depositAndWithdrawAmountToTransactionHistory("2", 2000.00,
							 "Savings", 1200.00, "_", "jdfskldfj")).thenReturn("pass");
		 }
		
	}
	
	
	@Test
	public void testDepositMoney() throws Exception {
		mockMvc.perform(get("/amount/deposit").param("accountNumber", "2").param("amount", "2000.00")
				.param("transactionDate", "15/03/2016").param("remarks", "jdfskldfj")).andExpect(status().isOk())
				.andExpect(content().string("passed"));

	}
	
	@Test
	public void testWithdrawAmount() throws Exception {
				mockMvc.perform(get("/amount/withdraw").param("accountNumber", "2").param("amount", "2000.00")
				.param("transactionDate", "24/03/2017").param("remarks", "done")).andExpect(status().isOk())
				.andExpect(content().string("pass"));

	}
}

