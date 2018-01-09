package com.valuelabs.lms.dao;

import java.util.List;

import com.valuelabs.lms.model.Employee;
import com.valuelabs.lms.model.EmployeeLeaves;

public interface ManagerDao {
	public List<EmployeeLeaves> handleLeaveRequest(String managerEmpId);
	public boolean acceptLeaveRequest(int sno);
	public boolean rejectLeaveRequest(int sno);
	public List<EmployeeLeaves> showReportingEmployeesDetails(String managerEmpId);
	public List<Employee> displayEmployeeDataInToolTip(String empId);

}
