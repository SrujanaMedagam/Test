package com.valuelabs.lms.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuelabs.lms.bean.EmployeeBean;
import com.valuelabs.lms.dao.EmployeeProfileDao;
import com.valuelabs.lms.model.Phone;

@Service("employeeprofileservice")
public class EmployeeProfileServiceImpl  implements EmployeeProfileService{
	@Autowired
	private EmployeeProfileDao employeeProfileDao;

	@Override
	public boolean saveEmployeeDetails(EmployeeBean employeeBean) {
		Set<Phone> phoneNumbers = new HashSet<Phone>();
		phoneNumbers.add(new Phone("mobileNumber",employeeBean.getMobNo()));
		phoneNumbers.add(new Phone("alternateMobileNumber",employeeBean.getAlMobNo()));
		
		if(employeeProfileDao.saveEmployeeDetails(employeeBean, phoneNumbers))
				{
			return true;
				}
		
		
		return false;
	}
	
	

}
