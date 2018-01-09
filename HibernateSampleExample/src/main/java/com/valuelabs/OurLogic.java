package com.valuelabs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OurLogic {
 
	public static void main(String args[])
	{
 
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();	
		  Transaction tx = session.beginTransaction();
 
		//Store the data
		/*
		Student s1=new Student();
		s1.setStudentId(1);
		s1.setStudentName("James");
		s1.setMarks(98);
 
		Student s2=new Student();
		s2.setStudentId(2);
		s2.setStudentName("Lee");
		s2.setMarks(99);
 
		Course c1=new Course();
		c1.setCourseId(9);
		c1.setCourseName("Hibernate");
		c1.setDuration(7);
 
		Course c2=new Course();
		c2.setCourseId(1);
		c2.setCourseName("Java");
		c2.setDuration(30);
 
		Set s =new HashSet();
		      s.add(c1);
		      s.add(c2);
 
		s1.setCourses(s);
		s2.setCourses(s);
		
		 session.save(s1);
		 session.save(s2);*/
 
		  /*Criteria query =  session.createCriteria(Student.class);
			 query.setFirstResult(2);
			 query.setMaxResults(110);*/
 
		 Query query =  session.createQuery("from Student");
		 query.setFirstResult(0);
		 query.setMaxResults(610);
		 List list = query.list();
		 Iterator it = list.iterator();
		 while(it.hasNext()){
			Student stu = (Student) it.next();
			System.out.println(stu.getStudentId());
			System.out.println(stu.getStudentName());
		 }
		 
		    tx.commit();
 
		    session.close();
		  //  System.out.println(list);
		    System.out.println("Many To Many Bi-Directional is Done..!!");
		    factory.close();
 
	}
}