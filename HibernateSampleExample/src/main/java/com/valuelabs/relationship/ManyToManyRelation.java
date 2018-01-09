package com.valuelabs.relationship;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class ManyToManyRelation {

	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		Session session = cfg.configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		/*Student s3=new Student();
		s3.setsId(3);
		s3.setsName("Sahasra");
		
		
		
		
		Course c3=new Course();
		c3.setcId(33);
		c3.setcName(".net");
		
		
		
		Set set=new HashSet();
		set.add(c3);
		s3.setCourses(set);
		
		session.save(s3);*/
		
		Student s=(Student)session.get(Student.class, 3);
		/*System.out.println(s.getsName());
		System.out.println(s.getCourses());*/
		
		t.commit();
		session.close();
		
		
		
	}

}
