package com.valuelabs.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.dao.FundsTransferDao;
import com.valuelabs.service.FundsTransferService;
import com.valuelabs.service.FundsTransferServiceImpl;

@Configuration
public class TestFundsTransferService {
	@Bean
	@Qualifier("fundsTransferService")
	public FundsTransferService fundsTransferService(){
		return new FundsTransferServiceImpl();
	}
	@Bean
	@Qualifier("accountTransactionDetailsBean")
	public AccountTransactionDetailsBean accountTransactionDetailsBean(){
		return Mockito.mock(AccountTransactionDetailsBean.class);
	}
	
	@Bean 
	@Qualifier("fundsTransferDaoMock")
	public FundsTransferDao fundsTransferDao(){
		return Mockito.mock(FundsTransferDao.class);
	}
	
}
