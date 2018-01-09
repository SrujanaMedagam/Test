package com.valuelabs.lms.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.valuelabs.lms.bean.AdminPermissionBean;
import com.valuelabs.lms.dao.AdminPermissionDao;
import com.valuelabs.lms.model.AdminPermission;

@Service("adminpermissionservice")
public class AdminPermissionServiceImpl implements AdminPermissionService {
	@Autowired
	AdminPermissionDao adminPermissionDao;

	@Override
	public boolean adminPermission(String role, String empName, String empId, String password, String email, String manager){

		AdminPermissionBean adminPermissionBean = new AdminPermissionBean();
		adminPermissionBean.setRole(role);
		adminPermissionBean.setEmpName(empName);
		adminPermissionBean.setEmpId(empId);
		adminPermissionBean.setPassword(password);
		adminPermissionBean.setEmail(email);
		adminPermissionBean.setManager(manager);

		if (adminPermissionDao.adminPermissionInfo(adminPermissionBean)) {
			return true;
		}

		return false;
	}

	@Override
	public List<AdminPermission> getallEmployee() {
		List<AdminPermission> list = adminPermissionDao.getAllEmployees();
		return list;
	}

	@Override
	public List<AdminPermission> getAllManagerIds() {
		List<AdminPermission> list = adminPermissionDao.getAllManagerids();
		return list;
	}

	@Override
	public boolean checkEmployeeId(String empId) {
		List<AdminPermission> list = adminPermissionDao.checkEmployeeId(empId);
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteRecord(String empId) {
		System.out.println("Service method started");
		boolean result = false;
		List<AdminPermission> list = adminPermissionDao.getAllEmployees();
		Iterator<AdminPermission> iterator = list.iterator();

		while (iterator.hasNext()) {
			AdminPermission adminPermission = iterator.next();
			System.out.println(adminPermission.getEmpId());
			if (adminPermission.getEmpId().equals(empId)) {
				System.out.println("both are equal");
				result = adminPermissionDao.deleteEmployeeRecord(empId);
				System.out.println(result);
			}
		}
		if (result) {
			return true;
		} else
			return false;
	}
	@Override
	public boolean updateEmpDetails(String empId, String empName, String role, String email, String manager) {		
		if (adminPermissionDao.setUpdatedEmpDetails(empId, empName, role, email, manager)) {
			return true;
		} else
			return false;

	}
	
	@Override
	public boolean updatePassword(String empId, String newPassword) {
		if (adminPermissionDao.setUpdatedEmpPassword(empId, newPassword)) {
			return true;
		} else
			return false;
	}

}
