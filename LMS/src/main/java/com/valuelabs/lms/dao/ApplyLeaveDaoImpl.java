package com.valuelabs.lms.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.valuelabs.lms.bean.EmployeeLeavesInfo;
import com.valuelabs.lms.model.AdminPermission;
import com.valuelabs.lms.model.EmployeeLeaves;

@Repository
@Transactional
public class ApplyLeaveDaoImpl implements ApplyLeavesDao{
@Autowired
private HibernateTemplate hibernateTemplate;
	@Override
	public boolean applyLeaveInfo(EmployeeLeavesInfo empleavesinfo) {
		
		EmployeeLeaves empleaves=new EmployeeLeaves();
		empleaves.setEid(empleavesinfo.getEid());
		empleaves.setFromDate(empleavesinfo.getFromDate());
		empleaves.setToDate(empleavesinfo.getToDate());
		empleaves.setNoOfDays(empleavesinfo.getNoOfDays());
		empleaves.setReason(empleavesinfo.getReason());
		empleaves.setTotalNoOfLeaves(empleavesinfo.getTotalNoOfLeaves());
		empleaves.setReportingManager(empleavesinfo.getReportingManager());
		hibernateTemplate.save(empleaves);
		return true;

}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeLeaves> getAplliedLeavesDetails(String eid,String fromDate, String toDate) {
		
		String hql="from EmployeeLeaves emp where emp.eid=? and emp.fromDate=? and emp.toDate=?";
		return (List<EmployeeLeaves>) hibernateTemplate.find(hql, eid,fromDate,toDate);
		
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean cancelLeaveRequest(String eid, String fromDate, String toDate) {
		
		String hql="from EmployeeLeaves emp where emp.eid = ? and emp.fromDate= ? and emp.toDate= ? ";
		List<EmployeeLeaves> updateEmpleaves=(List<EmployeeLeaves>) hibernateTemplate.find(hql,eid,fromDate,toDate);
		Iterator<EmployeeLeaves> it=updateEmpleaves.iterator();
		while(it.hasNext())
		{
			EmployeeLeaves updateEmployeeLeaveStatus=it.next();
			updateEmployeeLeaveStatus.setLeaveStatus(2);
			hibernateTemplate.update(updateEmployeeLeaveStatus);			
		}
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminPermission> getManagerEmployeeId( String empId) {
		
		String hql="from AdminPermission emp where emp.empId=?";
		return (List<AdminPermission>) hibernateTemplate.find(hql, empId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeLeaves> employeeBalanceLeaves(String empId) {
		int leaveStatus=1;
		String hql="from EmployeeLeaves emp where emp.eid=? and emp.leaveStatus=?";
		return (List<EmployeeLeaves>) hibernateTemplate.find(hql, empId,leaveStatus);
	}

	
}
