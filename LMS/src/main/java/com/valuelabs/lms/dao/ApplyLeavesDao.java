package com.valuelabs.lms.dao;

import java.util.List;

import com.valuelabs.lms.bean.EmployeeLeavesInfo;
import com.valuelabs.lms.model.AdminPermission;
import com.valuelabs.lms.model.EmployeeLeaves;

public interface ApplyLeavesDao {
	
	public boolean applyLeaveInfo(EmployeeLeavesInfo empleaves);
	public List<AdminPermission> getManagerEmployeeId(String empId);
	public List<EmployeeLeaves> getAplliedLeavesDetails(String eid,String fromDate, String toDate);
	public boolean cancelLeaveRequest(String eid, String fromDate, String toDate);
	public List<EmployeeLeaves> employeeBalanceLeaves(String empId);
}
