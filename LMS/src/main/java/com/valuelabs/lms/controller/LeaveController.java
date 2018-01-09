package com.valuelabs.lms.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valuelabs.lms.bean.EmployeeBean;
import com.valuelabs.lms.bean.EmployeeLeavesInfo;
import com.valuelabs.lms.model.AdminPermission;
import com.valuelabs.lms.model.EmployeeLeaves;
import com.valuelabs.lms.service.ApplyLeaveService;
import com.valuelabs.lms.service.EmployeeProfileService;

@Controller
@RequestMapping("/leave")
public class LeaveController {
	@Autowired
	private ApplyLeaveService applyLeaveService;
	@Autowired
	private EmployeeProfileService employeeProfileService;
	
	@RequestMapping(value="/applyleave", method=RequestMethod.POST)
	public @ResponseBody List<String> applyLeave(@RequestBody EmployeeLeavesInfo leaveData)
	{
		System.out.println("reached");
		System.out.println(leaveData.getEid());
		List<String> list=new ArrayList<>();
		if(applyLeaveService.applyLeave(leaveData.getEid(),leaveData.getFromDate(),leaveData.getToDate(),leaveData.getNoOfDays(),leaveData.getReason()))
		{
			list.add("passed");
			return list;
		}
		list.add("failed");
		return list;
		
	}
	@RequestMapping("/appliedleaves")
	public @ResponseBody List<EmployeeLeaves> getAplliedLeavesDetails(@RequestParam("eid") String eid,
			@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate)
	{
		System.out.println(eid+" "+fromDate+" "+toDate);
		List<EmployeeLeaves> list=applyLeaveService.getAppliedLeavesDetails(eid.trim(), fromDate.trim(), toDate.trim());
		Iterator<EmployeeLeaves> it=list.iterator();
		System.out.println(it.next().getReason());
		return list;
		
	}
	@RequestMapping("/getReportingManager")
	public @ResponseBody String getReportingManager(@RequestParam("empId") String empId)
	{
		System.out.println(empId);
		List<AdminPermission> list=applyLeaveService.getReportingManager(empId);
		Iterator<AdminPermission> it=list.iterator();
		String reportingManager=it.next().getEmpName();
		return reportingManager;
		
	}
	
	
	@RequestMapping(value="/cancelLeaves",method=RequestMethod.PUT)
	public @ResponseBody List<String> cancelLeaves(@RequestBody EmployeeLeavesInfo updateLeaveData)
	{
		System.out.println("reached2");
		System.out.println(updateLeaveData.getFromDate());
		List<String> list= new ArrayList<>();
		if(applyLeaveService.cancelLeaveRequest(updateLeaveData.getEid(),updateLeaveData.getFromDate(),updateLeaveData.getToDate()))
				{
			list.add("passed");
			return list;
				}
		list.add("failed");
		return list;
		
	}
	@RequestMapping(value="/saveEmployeeDetails", method=RequestMethod.POST)
	public @ResponseBody List<String> saveEmployeeDetails(@RequestBody EmployeeBean employeeBean)
	{
		System.out.println("reached");
		System.out.println(employeeBean.getEmpId());
		System.out.println(employeeBean.getMobNo());
		System.out.println(employeeBean.getAlMobNo());
		List<String> list=new ArrayList<>();
		if(employeeProfileService.saveEmployeeDetails(employeeBean))
		{
			list.add("passed");
			return list;
		}
		list.add("failed");
		return list;
		
	}
	@RequestMapping(value="/getEmployeeBalanceLeaves", method=RequestMethod.GET)
	public @ResponseBody float employeeBalanceLeaves(@RequestParam("empId") String empId)
	{
		System.out.println("reached2");
		System.out.println(empId);
		float balanceLeaves=applyLeaveService.employeeBalanceLeaves(empId);
		return balanceLeaves;
		
	}
	
	

}
