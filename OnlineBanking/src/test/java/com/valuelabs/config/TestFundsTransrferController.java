package com.valuelabs.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valuelabs.controller.FundsTransferController;
import com.valuelabs.service.FundsTransferService;
import com.valuelabs.service.LoginService;

@Configuration
public class TestFundsTransrferController {
	@Bean
	@Qualifier("fundsTransferController")
	public FundsTransferController fundsTransferController(){
		return new FundsTransferController();
	}
	@Bean
	@Qualifier("fundsTransferService")
	public FundsTransferService fundsTransferService(){
		return Mockito.mock(FundsTransferService.class);
	}
	
	@Bean
	@Qualifier("loginService")
	public LoginService loginService(){
		return Mockito.mock(LoginService.class);
	}
	
	

}
