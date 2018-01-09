package com.valuelabs.fetch;

import java.util.HashSet;
import java.util.*;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;


public class FetchTest {
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		Session session = cfg.configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		org.hibernate.Query q = session.createQuery("From Employee");
		List list = q.list();
		for(Object obj:list){
			Employee emp=(Employee)list;
			System.out.println(emp);
		}
	/*	Employee emp=new Employee();
		emp.setEid(1);
		emp.setName("Srujana");
		
		Address add1=new Address();
		add1.setAno(1);
		add1.setStreet("Banjara");
		add1.setState("AP");
		
		Address add2=new Address();
		add2.setAno(2);
		add2.setStreet("BanjaraHills");
		add2.setState("TS");
		Set set=new HashSet();
		set.add(add1);
		set.add(add2);
		
		
		emp.setAddress(set);
		session.save(emp);
		Address add=new Address();
		Owners o1=new Owners();
		o1.setOwnername("RK");
		Owners o2=new Owners();
		o2.setOwnername("KP");
		Set set1=new HashSet();
		set1.add(o1);
		set1.add(o2);
		 
		add1.setOwners(set1);
		add2.setOwners(set1);
		emp.setAddress(set);
		session.save(emp);*/
		
		
		/*Employee emp=new Employee();
		emp.setEid(2);
		emp.setName("Sai");
		Address add1=new Address();
		add1.setAno(5);
		add1.setStreet("KPHP");
		add1.setState("TS");
		Set set1=new HashSet();
		set1.add(add1);
		emp.setAddress(set1);
		session.save(emp);*/
		
		
		
		
		Employee e= (Employee)session.load(Employee.class,2);
		e.getEid();
		System.out.println(e.getName());;
		System.out.println(e.getAddress());
		/*System.out.println(e.getAddress());*/
	
		
		
		
		t.commit();
		session.close();
		

}
}