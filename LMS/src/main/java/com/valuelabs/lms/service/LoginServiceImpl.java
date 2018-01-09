package com.valuelabs.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuelabs.lms.dao.LoginDao;


@Service("loginservice")
public class LoginServiceImpl implements LoginService{
	/**
	 * @param emp
	 * @param con
	
	 */
	@Autowired
	private LoginDao emp;
	
	
	
	@Override
	public boolean checkEmployeeLoginCredentials(String username, String password,String role) {
		@SuppressWarnings("rawtypes")
		List list=emp.checkLoginCredentials(username,password);
		if(list.isEmpty())
		{
			System.out.println("false");
			
			return false;
		}
		else if(list.get(0).toString().equalsIgnoreCase(role))
		{
			System.out.println("true");
			
		return true;
		}
		else
		{
		return false;
		}
		
	}
	
	
	
	
	

}
