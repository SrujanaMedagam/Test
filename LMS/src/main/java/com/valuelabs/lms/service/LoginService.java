package com.valuelabs.lms.service;


public interface LoginService {
	boolean checkEmployeeLoginCredentials(String username, String password,String role);

}
