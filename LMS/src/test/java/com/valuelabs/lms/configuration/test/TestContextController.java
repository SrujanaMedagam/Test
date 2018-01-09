package com.valuelabs.lms.configuration.test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valuelabs.lms.service.LoginService;

@Configuration

public class TestContextController  {

	@Bean
    @Qualifier("loginServiceMock")
    public LoginService loginService() {
        return Mockito.mock(LoginService.class);
    }

    
}
