package com.valuelabs.lms.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valuelabs.lms.model.Employee;
import com.valuelabs.lms.model.EmployeeLeaves;
import com.valuelabs.lms.model.Phone;
import com.valuelabs.lms.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	@RequestMapping("/handleLeaveRequests")
	public @ResponseBody List<EmployeeLeaves> handleLeaveRequests(@RequestParam("managerEmpId") String managerEmpId)
	{
		List<EmployeeLeaves> list=managerService.handleLeaveRequests(managerEmpId);
		Iterator<EmployeeLeaves> it=list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().getReason());
		}
		return list;
	}
	
	@RequestMapping("/acceptLeaveRequest")
	public @ResponseBody String acceptLeaveRequest(@RequestParam("sno") int sno)
	{
		if(managerService.acceptLeaveRequest(sno))
		{
			return "passed";
		}
		
		return "failed";
		
	}
	@RequestMapping("/rejectLeaveRequest")
	public @ResponseBody String rejectLeaveRequest(@RequestParam("sno") int sno)
	{
		if(managerService.rejectLeaveRequest(sno))
		{
			return "passed";
		}
		
		return "failed";
		
	}
	
	@RequestMapping("/showReportingEmployeesDetails")
	public @ResponseBody List<EmployeeLeaves> showReportingEmployeesDetails(@RequestParam("managerEmpId") String managerEmpId)
	{
		List<EmployeeLeaves> list=managerService.showReportingEmployeesDetails(managerEmpId);
		Iterator<EmployeeLeaves> it=list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().getEid());
		}
		return list;
	}
	@RequestMapping("/managerGenerateReport")
	public ModelAndView managerGenerateReport(@RequestParam("managerEmpId") String managerEmpId)
	{
		System.out.println(managerEmpId);
		System.out.println("1");
		List<EmployeeLeaves> list=managerService.showReportingEmployeesDetails(managerEmpId);
		Iterator<EmployeeLeaves> it=list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().getEid());
		}
		return new ModelAndView("excelView", "generateReport", list);
	}
	
	@RequestMapping("/displayEmployeeDataInToolTip")
	public @ResponseBody List<Employee> displayEmployeeDataInToolTip(@RequestParam("empId") String empId)
	{
		System.out.println(empId);
		System.out.println("1");
		List<Employee> list=managerService.displayEmployeeDataInToolTip(empId);
	/*	Iterator<Employee> it= list.iterator();
		while(it.hasNext())
		{
			Employee emp= it.next();
			System.out.println(emp.getFatherName());
			System.out.println(emp.getFirtsName());
			Set<Phone> phone=emp.getEmployeePhoneNumbers();
			Iterator<Phone> itph=phone.iterator();
			while(itph.hasNext())
			{
				Phone pho=itph.next();
				System.out.println(pho.getPhoneId());
				System.out.println(pho.getPhoneNumber());
				System.out.println(pho.getPhoneType());
			}
		}*/
		return list;
	}
}
