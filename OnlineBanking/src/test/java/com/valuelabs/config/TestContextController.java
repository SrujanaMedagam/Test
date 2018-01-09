package com.valuelabs.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valuelabs.controller.LoginController;
import com.valuelabs.service.LoginService;

@Configuration

public class TestContextController  {
	@Bean
	@Qualifier("loginController")
	public LoginController loginController() {
	return new LoginController();
	}

	@Bean
    @Qualifier("loginServiceMock")
    public LoginService loginService() {
        return Mockito.mock(LoginService.class);
    }

    
}
