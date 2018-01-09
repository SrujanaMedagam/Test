package com.valuelabs.lms.service;

import java.util.List;

import com.valuelabs.lms.model.AdminPermission;

public interface AdminPermissionService {

	List<AdminPermission> getallEmployee();
	public boolean adminPermission(String role, String empId, String empName, String email, String password, String manager);	
	List<AdminPermission> getAllManagerIds();
	public boolean checkEmployeeId(String empId);
	public boolean deleteRecord(String empId);
	public boolean updateEmpDetails(String empId, String empName, String role, String email, String manager);	
	public boolean updatePassword(String empId, String newPassword);
	
}
