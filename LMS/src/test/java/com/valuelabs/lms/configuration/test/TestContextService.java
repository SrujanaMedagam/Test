package com.valuelabs.lms.configuration.test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valuelabs.lms.dao.LoginDao;
import com.valuelabs.lms.service.LoginService;
import com.valuelabs.lms.service.LoginServiceImpl;

@Configuration
public class TestContextService {
	
	@Bean
	@Qualifier("loginServiceInstance")
	public LoginService loginService() {
	return new LoginServiceImpl();
	}
	
 
 
    @Bean   
    @Qualifier("loginDaoMock")
    public LoginDao loginDao() {
        return Mockito.mock(LoginDao.class);
    }
    
    
    
   
}