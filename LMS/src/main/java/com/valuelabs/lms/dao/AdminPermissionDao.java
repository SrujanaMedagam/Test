package com.valuelabs.lms.dao;

import java.util.List;
import com.valuelabs.lms.bean.AdminPermissionBean;
import com.valuelabs.lms.model.AdminPermission;

public interface AdminPermissionDao {	
	public boolean adminPermissionInfo(AdminPermissionBean adminPermissionBean);	
	List<AdminPermission> getAllEmployees();
	List<AdminPermission> getAllManagerids();
	List<AdminPermission> checkEmployeeId(String empId);
	public boolean deleteEmployeeRecord(String empId);
	public boolean setUpdatedEmpDetails(String empId, String empName, String role, String email, String manager);	
	public boolean setUpdatedEmpPassword(String empId, String newPassword);	
}
