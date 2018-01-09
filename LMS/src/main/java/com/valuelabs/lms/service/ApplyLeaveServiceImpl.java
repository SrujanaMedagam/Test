package com.valuelabs.lms.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valuelabs.lms.bean.EmployeeLeavesInfo;
import com.valuelabs.lms.dao.ApplyLeavesDao;
import com.valuelabs.lms.model.AdminPermission;
import com.valuelabs.lms.model.EmployeeLeaves;
@Service("leaveservices")
public class ApplyLeaveServiceImpl implements ApplyLeaveService {
	@Autowired
	ApplyLeavesDao applyLeavedao;
	

	@Override
	public boolean applyLeave(String eid, String fromDate, String toDate, float noOfDays, String reason) {
		
		List<AdminPermission> l=	applyLeavedao.getManagerEmployeeId(eid);
		Iterator<AdminPermission> it=l.iterator();
		EmployeeLeavesInfo empleaves=new EmployeeLeavesInfo();
		empleaves.setEid(eid);
		empleaves.setFromDate(fromDate);
		empleaves.setToDate(toDate);
		empleaves.setNoOfDays(noOfDays);
		empleaves.setReason(reason);
		empleaves.setTotalNoOfLeaves(30);
		empleaves.setReportingManager(it.next().getManager());
		if(applyLeavedao.applyLeaveInfo(empleaves))
		{
			return true;
		}
		return false;
		
		
	}

	@Override
	public List<EmployeeLeaves> getAppliedLeavesDetails(String eid,String fromDate, String toDate) {
		List<EmployeeLeaves> list= applyLeavedao.getAplliedLeavesDetails(eid, fromDate, toDate);
		return list;
	}

	@Override
	public boolean cancelLeaveRequest(String eid, String fromDate, String toDate) {
		boolean flag=applyLeavedao.cancelLeaveRequest( eid, fromDate, toDate);
		return flag;
	}

	@Override
	public List<AdminPermission> getReportingManager(String empId) {
		List<AdminPermission> list= applyLeavedao.getManagerEmployeeId( empId);
		Iterator<AdminPermission> it=list.iterator();
		String reportingManagerId=it.next().getManager();
		List<AdminPermission> list1= applyLeavedao.getManagerEmployeeId(reportingManagerId);
		return list1;
	}

	@Override
	public float employeeBalanceLeaves(String empId) {
		List<EmployeeLeaves> employeeLeaves= applyLeavedao.employeeBalanceLeaves(empId);
		float totalEmployeeLeaves=22;
		float employeeTotalLeaves=0;
		float balanceleaves;
		Iterator<EmployeeLeaves> it= employeeLeaves.iterator();
		while(it.hasNext())
		{
			employeeTotalLeaves+=it.next().getNoOfDays();
		}
		balanceleaves=totalEmployeeLeaves-employeeTotalLeaves;
		return balanceleaves;
	}



}
