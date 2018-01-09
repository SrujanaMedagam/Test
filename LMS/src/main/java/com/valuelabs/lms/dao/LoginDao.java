package com.valuelabs.lms.dao;

import java.util.List;

import com.valuelabs.lms.model.AdminPermission;

public interface LoginDao {
	
	List<String> checkLoginCredentials(String username,String password);
	
	
}
