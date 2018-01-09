package com.valuelabs.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valuelabs.model.AccountDetails;
import com.valuelabs.service.HomePageService;
import com.valuelabs.service.LoginService;

@Controller
@RequestMapping("/homepage")
public class HomePageController {
	@Autowired(required = true)
	HomePageService homePageService;
	@Autowired(required = true)
	LoginService loginService;

	@RequestMapping("/accountDetails")
	public @ResponseBody String accountDetails(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String result;
		String accountDetails = loginService.checkUserAccountNumber(username, password);
				List accountDetailslist = homePageService.checkAccountDetails(accountDetails);
		if (!accountDetailslist.isEmpty()) {
			result = "passed";
		} else {
			result = "failed";
		}
		return result;
	}

	@RequestMapping("/showdetails")
	public @ResponseBody List showDetails(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String  accountDetails = loginService.checkUserAccountNumber(username, password);
		List<AccountDetails> accountDetailslist = homePageService.checkAccountDetails(accountDetails);
		Iterator<AccountDetails> accountDetailsList = accountDetailslist.iterator();
		AccountDetails accountDetail = (AccountDetails) accountDetailsList.next();
		return accountDetailslist;
	}

}
