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
import com.valuelabs.lms.bean.AdminPermissionBean;
import com.valuelabs.lms.model.AdminPermission;
import com.valuelabs.lms.service.AdminPermissionService;

@Controller
@RequestMapping("/admin")
public class adminController {
	
	@Autowired
	private AdminPermissionService adminPermissionService;

	@RequestMapping(value = "/adminleave", method = RequestMethod.POST)
	public @ResponseBody List<String> adminLeavePermission(@RequestBody AdminPermissionBean adminBean) {

		System.out.println("reached1");
		System.out.println(adminBean.getEmpId());
		List<String> list = new ArrayList<>();

		if (adminPermissionService.adminPermission(adminBean.getRole(), adminBean.getEmpName(), adminBean.getEmpId(),
				adminBean.getPassword(), adminBean.getEmail(), adminBean.getManager())) {
			list.add("passed");
			return list;
		}
		list.add("failed");
		return list;

	}

	/*
	 * @RequestMapping(value = "/updateEmployeeDetails", method =
	 * RequestMethod.POST) public @ResponseBody String
	 * updateEmployeeRecords(@RequestBody AdminPermissionBean adminBean){
	 * 
	 * System.out.println("reached");
	 * 
	 * System.out.println(adminBean.getEmpId());
	 * System.out.println(adminBean.getEmpName());
	 * System.out.println(adminBean.getRole());
	 * System.out.println(adminBean.getEmail());
	 * System.out.println(adminBean.getManager());
	 * 
	 * 
	 * if (adminPermissionService.updateEmpDetails(adminBean.getEmpId(),
	 * adminBean.getEmpName(), adminBean.getRole(), adminBean.getEmail(),
	 * adminBean.getManager())) { System.out.println("passed&&&&&&&&&"); return
	 * "pass"; } else{ return "failed"; }
	 * 
	 * 
	 * }
	 */
	@RequestMapping("/showdetails")
	public @ResponseBody List<AdminPermission> showdetails() {

		List<AdminPermission> list = adminPermissionService.getallEmployee();
		Iterator<AdminPermission> it = list.iterator();
		while (it.hasNext()) {

			AdminPermission adminPermission = it.next();
			System.out.println(adminPermission.getEmpId());
			System.out.println(adminPermission.getEmpName());
			System.out.println(adminPermission.getEmail());
			System.out.println(adminPermission.getManager());
		}

		return list;
	}
	
	@RequestMapping("/getAllEmpIds")
	public @ResponseBody List<AdminPermission> getAllEmployeeIds() {

		List<AdminPermission> list = adminPermissionService.getallEmployee();
		Iterator<AdminPermission> it = list.iterator();
		while (it.hasNext()) {

			AdminPermission adminPermission = it.next();
			System.out.println(adminPermission.getEmpId());
			System.out.println(adminPermission.getEmpName());
			System.out.println(adminPermission.getEmail());
			System.out.println(adminPermission.getManager());
		}

		return list;
	}


	@RequestMapping("/getAllManagerIds")
	public @ResponseBody List<AdminPermission> getAllManagerIds() {
		List<AdminPermission> list = adminPermissionService.getAllManagerIds();
		Iterator<AdminPermission> it = list.iterator();
		while (it.hasNext()) {
			AdminPermission adminPermission = it.next();
			System.out.println(adminPermission.getEmpId());
		}

		return list;
	}

	@RequestMapping("/checkEmployeeId")
	public @ResponseBody String checkEmployeeId(@RequestParam("empId") String empId) {
		if (adminPermissionService.checkEmployeeId(empId)) {
			return "passed";
		}
		return "failed";

	}

	@RequestMapping("/deleteRecord")
	public @ResponseBody String deleteRecordController(@RequestParam("empId") String empId) {
		System.out.println("deleteRecordController");
		if (adminPermissionService.deleteRecord(empId)) {
			System.out.println("calling service");
			return "passed";
		}

		return "failed";
	}

	@RequestMapping(value = "/updateEmployeeDetails")
	public @ResponseBody String updateEmployeeRecords(@RequestParam("empId") String empId,
			@RequestParam("empName") String empName, @RequestParam("role") String role,
			@RequestParam("email") String email, @RequestParam("manager") String manager) {

		System.out.println("reached");
		System.out.println(empId + empName + role + email + manager);

		if (adminPermissionService.updateEmpDetails(empId, empName, role, email, manager)) {			
			return "passed";
		}

		return "failed";

	}

	@RequestMapping(value = "/updatePassword")
	public @ResponseBody String updatePasswordController(@RequestParam("empId") String empId,
			@RequestParam("newPassword") String newPassword) {

		System.out.println("reached");

		if (adminPermissionService.updatePassword(empId, newPassword)) {			
			return "passed";
		}

		return "failed";

	}

}
