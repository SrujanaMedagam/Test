package com.valuelabs.lms.configuration.test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.valuelabs.lms.dao.LoginDao;
import com.valuelabs.lms.dao.LoginDaoImpl;

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
}