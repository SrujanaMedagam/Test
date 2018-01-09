package com.valuelabs.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.dao.FundsTransferDao;
import com.valuelabs.dao.FundsTransferDaoImpl;
import com.valuelabs.model.AccountTransactionDetails;

@Configuration
public class TestFundsTransferDao {
	@Bean
	@Qualifier("fundsTransferDaoMock")
	public FundsTransferDao fundsTransferDao() {
		return new FundsTransferDaoImpl();
	}

	@Bean
	@Qualifier("accountTransactionDetails")
	public AccountTransactionDetails accountTransactionDetails() {
		return Mockito.mock(AccountTransactionDetails.class);
	}

	@Bean
	@Qualifier("accountTransactionDetailsBean")
	public AccountTransactionDetailsBean accountTransactionDetailsBean() {
		return Mockito.mock(AccountTransactionDetailsBean.class);
	}

	@Bean
    @Qualifier("hibernateTemplateInstance")
    public HibernateTemplate hibernateTemplate() {
        return Mockito.mock(HibernateTemplate.class);
    }
}
