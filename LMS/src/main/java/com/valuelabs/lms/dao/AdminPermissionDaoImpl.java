package com.valuelabs.lms.dao;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.valuelabs.lms.bean.AdminPermissionBean;
import com.valuelabs.lms.model.AdminPermission;

@Transactional
@Repository
public class AdminPermissionDaoImpl implements AdminPermissionDao {
	Transaction transaction = null;
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean adminPermissionInfo(AdminPermissionBean adminPermissionBean) {

		AdminPermission adminPermission = new AdminPermission();
		adminPermission.setRole(adminPermissionBean.getRole());
		adminPermission.setEmpName(adminPermissionBean.getEmpName());
		adminPermission.setEmpId(adminPermissionBean.getEmpId());
		adminPermission.setEmail(adminPermissionBean.getEmail());
		adminPermission.setPassword(adminPermissionBean.getPassword());
		adminPermission.setManager(adminPermissionBean.getManager());
		hibernateTemplate.save(adminPermission);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminPermission> getAllEmployees() {
		System.out.println("Getting all employees details");
		String hql = "from AdminPermission";
		return (List<AdminPermission>) hibernateTemplate.find(hql);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminPermission> getAllManagerids() {
		String hql = "from AdminPermission admin where admin.role=?";
		return (List<AdminPermission>) hibernateTemplate.find(hql, "manager");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminPermission> checkEmployeeId(String empId) {
		String hql = "from AdminPermission admin where admin.empId=?";
		return (List<AdminPermission>) hibernateTemplate.find(hql, empId);
	}

	@Override
	public boolean deleteEmployeeRecord(String empId) {
		System.out.println("deleteEmployeeRecord reached");
		hibernateTemplate.bulkUpdate("DELETE AdminPermission admin where admin.empId=?", empId);
		return true;
	}

	@Override
	public boolean setUpdatedEmpDetails(String empId, String empName, String role, String email, String manager) {

		String hql = "from AdminPermission a where a.empId=?";
		
		@SuppressWarnings("rawtypes")
		AdminPermission adminPermission = (AdminPermission) ((List) hibernateTemplate.find(hql, empId)).get(0);

		adminPermission.setEmpName(empName);
		adminPermission.setRole(role);
		adminPermission.setEmail(email);
		adminPermission.setManager(manager);
		//System.out.println(adminPermission.getEmpName() + "______");
		hibernateTemplate.save(adminPermission);

		return true;
	}

	@Override
	public boolean setUpdatedEmpPassword(String empId, String newPassword) {

		String hql = "from AdminPermission a where a.empId=?";

		@SuppressWarnings("rawtypes")
		AdminPermission adminPermission = (AdminPermission) ((List) hibernateTemplate.find(hql, empId)).get(0);

		adminPermission.setPassword(newPassword);
		//System.out.println(adminPermission.getPassword() + "______");
		hibernateTemplate.save(adminPermission);

		return true;
	}

}
