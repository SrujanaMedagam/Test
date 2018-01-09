package com.valuelabs.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.dao.DepositAndWithdrawDao;
import com.valuelabs.service.DepositAndWithdrawService;
import com.valuelabs.service.DepositAndWithdrawServiceImpl;

@Configuration
public class TestDepositAndWithdrawService {
	@Bean
	@Qualifier("depositAndWithdrawService")
	public DepositAndWithdrawService depositAndWithdrawService(){
		return new DepositAndWithdrawServiceImpl();
	}
	
	@Bean
	@Qualifier("accountTransactionDetailsBean")
	public AccountTransactionDetailsBean accountTransactionDetailsBean(){
		return new AccountTransactionDetailsBean();
	}

	@Bean
	@Qualifier("depositAndWithdrawDaoMock")
	public DepositAndWithdrawDao dsepositAndWithdrawDao(){
		return Mockito.mock(DepositAndWithdrawDao.class);
		
	}
	 
	
}
