package com.valuelabs.lms.service;

import java.util.List;

import com.valuelabs.lms.model.AdminPermission;
import com.valuelabs.lms.model.EmployeeLeaves;

public interface ApplyLeaveService {
	public boolean applyLeave(String eid, String fromDate, String toDate, float noOfDays, String reason );
	public List<EmployeeLeaves> getAppliedLeavesDetails(String eid,String fromDate,String toDate);
	public boolean cancelLeaveRequest(String eid, String fromDate, String toDate);
	public List<AdminPermission> getReportingManager(String empId);
	public float employeeBalanceLeaves(String empId);
}
