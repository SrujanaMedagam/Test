package com.valuelabs;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class PaginationInHibernateWithCriteriaAPI {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			for (int i = 0; i < 20; i++) {
				Employee employee = new Employee();
				employee.setName("employe_"+i);
				employee.setSurname("surname_"+i);
				employee.setTitle("Engineer_"+i);
				employee.setCreated(new Date());
				session.save(employee);
			}
			
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}  
		
		session = sessionFactory.getCurrentSession();
		
		int pageNumber = 1;
		int pageSize = 20;
		
		try {
			session.beginTransaction();
			Query criteria = session.createQuery("from Employee");
			/*criteria.setFirstResult((pageNumber - 1) * pageSize);
			criteria.setMaxResults(pageSize);*/
			
			/*Criteria criteria = session.createCriteria(Employee.class);
			criteria.setFirstResult((pageNumber - 1) * pageSize);
			criteria.setMaxResults(pageSize);*/
			
			/*Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("id", 4));
			Employee result = (Employee) criteria.uniqueResult();
			System.out.println("Single result using Criteria  :  "+result.getName());*/
			
			
			
			List<Employee> employees = (List<Employee>) criteria.list();
			if (employees!=null) {
				System.out.println("Total Results:" + employees.size());
				for (Employee employee : employees) {
					System.out.println(employee.getId() + " - " + employee.getName());
				}
			}
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

}