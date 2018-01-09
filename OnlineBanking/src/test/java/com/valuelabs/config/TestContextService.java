package com.valuelabs.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valuelabs.dao.LoginDao;
import com.valuelabs.service.LoginService;
import com.valuelabs.service.LoginServiceImpl;

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