package com.valuelabs.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import com.valuelabs.dao.LoginDao;
import com.valuelabs.dao.LoginDaoImpl;
import com.valuelabs.model.AccountDetails;
import com.valuelabs.model.LoginDetails;


@Configuration
public class TestContextDao {

    @Bean
    @Qualifier("loginDaoInstance")
	public LoginDao loginDaoInstance() {
	return new LoginDaoImpl();
	}
    
    @Bean
    @Qualifier("hibernateTemplateInstance")
    public HibernateTemplate hibernateTemplate() {
        return Mockito.mock(HibernateTemplate.class);
    }
    @Bean
    @Qualifier("loginDetails")
    public LoginDetails loginDetails() {
        return Mockito.mock(LoginDetails.class);
    }
    @Bean
    @Qualifier("accountDetails")
    public AccountDetails accountDetails() {
        return Mockito.mock(AccountDetails.class);
    }
}