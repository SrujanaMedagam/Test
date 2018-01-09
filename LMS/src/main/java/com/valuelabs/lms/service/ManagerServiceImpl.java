package com.valuelabs.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuelabs.lms.dao.ManagerDao;
import com.valuelabs.lms.model.Employee;
import com.valuelabs.lms.model.EmployeeLeaves;
@Service("managerservice")
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	ManagerDao managerDao;
	
	@Override
	public List<EmployeeLeaves> handleLeaveRequests(String managerEmpId) {
		
		List<EmployeeLeaves> list=managerDao.handleLeaveRequest( managerEmpId);
		return list;
	}
	@Override
	public boolean acceptLeaveRequest(int sno) {
		
		boolean b=managerDao.acceptLeaveRequest( sno);
		return b;
	}
	@Override
	public boolean rejectLeaveRequest(int sno) {
		
		boolean b=managerDao.rejectLeaveRequest( sno);
		return b;
	}
	@Override
	public List<EmployeeLeaves> showReportingEmployeesDetails(String managerEmpId) {
		
		List<EmployeeLeaves> list= managerDao.showReportingEmployeesDetails( managerEmpId);
		return list;
	}
	@Override
	public List<Employee> displayEmployeeDataInToolTip(String empId) {
		List<Employee> list= managerDao.displayEmployeeDataInToolTip(empId);
		return list;
	}

	
}
