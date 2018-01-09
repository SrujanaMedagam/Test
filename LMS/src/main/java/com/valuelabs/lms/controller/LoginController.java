package com.valuelabs.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.valuelabs.lms.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService empinfo; 
	@RequestMapping("/")
	public String homepage()
	{
		System.out.println("asdfh");
		//return "login";
		return "index";
	}
	
	
	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)	
	public @ResponseBody String checkLoginCredentials(@RequestParam("uname") String username, @RequestParam("pass") String password,@RequestParam("role") String role) {
		System.out.println("1");
		System.out.println(username+" "+password);
		String result;
		if(empinfo.checkEmployeeLoginCredentials(username, password,role))
		{
			result="passed";
		}
		else
		{
			result="failed";
		}
		System.out.println(result);
		return result;
	    
	}

}
