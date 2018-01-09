package com.valuelabs.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.valuelabs.dao.DepositAndWithdrawDao;
import com.valuelabs.dao.DepositAndWithdrawDaoImpl;
import com.valuelabs.model.AccountDetails;
import com.valuelabs.model.AccountTransactionDetails;

@Configuration
public class TestDepostAndWithdrawDao {
	@Bean
	@Qualifier("depositAndWithdrawDaoMock")
	public DepositAndWithdrawDao depositAndWithdrawDao() {
		return new DepositAndWithdrawDaoImpl();
	}

	@Bean
	@Qualifier("accountDetails")
	public AccountDetails accountDetails() {
		return Mockito.mock(AccountDetails.class);
	}
	@Bean
	@Qualifier("accountTransactionDetails")
	public AccountTransactionDetails accountTransactionDetails() {
		return Mockito.mock(AccountTransactionDetails.class);
	}
	
	@Bean
    @Qualifier("hibernateTemplateInstance")
    public HibernateTemplate hibernateTemplate() {
        return Mockito.mock(HibernateTemplate.class);
    }
}
