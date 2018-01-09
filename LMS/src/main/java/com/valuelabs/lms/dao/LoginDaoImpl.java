package com.valuelabs.lms.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<String> checkLoginCredentials(String username,String password) {
	
		String hql="Select emp.role from AdminPermission emp where emp.empId=? and emp.password=?";
		return (List<String>) hibernateTemplate.find(hql,username,password);
	}



}
