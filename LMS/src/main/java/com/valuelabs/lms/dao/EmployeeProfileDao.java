package com.valuelabs.lms.dao;

import java.util.Set;

import com.valuelabs.lms.bean.EmployeeBean;
import com.valuelabs.lms.model.Phone;

public interface EmployeeProfileDao {
	
	public boolean saveEmployeeDetails(EmployeeBean employeeBean,Set<Phone> employeePhoneNumbers);

}
