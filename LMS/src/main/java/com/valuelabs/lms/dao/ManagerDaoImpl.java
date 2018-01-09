package com.valuelabs.lms.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.valuelabs.lms.model.Employee;
import com.valuelabs.lms.model.EmployeeLeaves;
import com.valuelabs.lms.model.Phone;

@Repository
@Transactional
public class ManagerDaoImpl implements ManagerDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;


	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeLeaves> handleLeaveRequest( String managerEmpId) {
		
		String hql="from EmployeeLeaves emp where emp.reportingManager=? and emp.leaveStatus=?";
		return (List<EmployeeLeaves>) hibernateTemplate.find(hql, managerEmpId,0);
	}
	
	@Override
	public boolean acceptLeaveRequest(int sno) {
		
		String hql="from EmployeeLeaves emp where emp.sno = ? ";
		@SuppressWarnings("unchecked")
		List<EmployeeLeaves> updateEmpleaves=(List<EmployeeLeaves>) hibernateTemplate.find(hql,sno);
		Iterator<EmployeeLeaves> it=updateEmpleaves.iterator();
		while(it.hasNext())
		{
			EmployeeLeaves approveEmployeeLeaveStatus=it.next();
			approveEmployeeLeaveStatus.setLeaveStatus(1);
			hibernateTemplate.update(approveEmployeeLeaveStatus);			
		}
		return true;
	}
	@Override
	public boolean rejectLeaveRequest(int sno) {
		
		String hql="from EmployeeLeaves emp where emp.sno = ? ";
		@SuppressWarnings("unchecked")
		List<EmployeeLeaves> updateEmpleaves=(List<EmployeeLeaves>) hibernateTemplate.find(hql,sno);
		Iterator<EmployeeLeaves> it=updateEmpleaves.iterator();
		while(it.hasNext())
		{
			EmployeeLeaves rejectEmployeeLeaveStatus=it.next();
			rejectEmployeeLeaveStatus.setLeaveStatus(3);
			hibernateTemplate.update(rejectEmployeeLeaveStatus);			
		}
		return true;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeLeaves> showReportingEmployeesDetails( String managerEmpId) {
		
		Criterion cr1=Restrictions.and(Restrictions.eq("reportingManager", managerEmpId),Restrictions.eq("leaveStatus", 1));
		Criterion cr2=Restrictions.and(Restrictions.eq("reportingManager", managerEmpId),Restrictions.eq("leaveStatus", 3));
		return (List<EmployeeLeaves>) hibernateTemplate.findByCriteria(
		        DetachedCriteria.forClass(EmployeeLeaves.class)
		        .add(Restrictions.or(cr1,cr2)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> displayEmployeeDataInToolTip(String empId) {
		String hql="from Employee emp where emp.empId = ? ";
		/*@SuppressWarnings("unchecked")
		List<Employee> empDetails=(List<Employee>) hibernateTemplate.find(hql,empId);
		Iterator<Employee> it= empDetails.iterator();
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
		return (List<Employee>) hibernateTemplate.find(hql,empId);
	}

}
