package com.valuelabs.lms.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.valuelabs.lms.bean.EmployeeBean;
import com.valuelabs.lms.model.Employee;
import com.valuelabs.lms.model.Phone;

@Repository
@Transactional
public class EmployeeProfileDaoImpl implements EmployeeProfileDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean saveEmployeeDetails(EmployeeBean employeeBean,Set<Phone> employeePhoneNumbers) {
		Employee employee= new Employee();
		employee.setEmpId(employeeBean.getEmpId());
		employee.setFirtsName(employeeBean.getFirtsName());
		employee.setLastName(employeeBean.getLastName());
		employee.setFatherName(employeeBean.getFatherName());
		employee.setAddress(employeeBean.getAddress());
		/*Set<Phone> phoneNumbers = new HashSet<Phone>();
		phoneNumbers.add(new Phone("house","32354353"));
		phoneNumbers.add(new Phone("mobile","9889343423"));*/
		employee.setEmployeePhoneNumbers(employeePhoneNumbers);
		hibernateTemplate.save(employee);
		return true;
	}


}
