package com.valuelabs.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.valuelabs.controller.DepositAndWithsrawController;
import com.valuelabs.service.DepositAndWithdrawService;

@Configuration
public class TestDepositAndWithdrawController {
	
	@Bean
	@Qualifier("depositAndWithsrawController")
	public DepositAndWithsrawController depositAndWithsrawController() {
	return new DepositAndWithsrawController();
	}

	@Bean
    @Qualifier("depositAndWithdrawService")
    public DepositAndWithdrawService depositAndWithdrawService() {
        return Mockito.mock(DepositAndWithdrawService.class);
    }


}
