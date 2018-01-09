package com.valuelabs.inheritance;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class UsingInheritanceToStoreDate {

	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		Session session = cfg.configure("hibernate.cfg.xml").buildSessionFactory().openSession();

		Transaction t = session.beginTransaction();
		Employee emp = new Employee();
		emp.setName("Srujana");

		Reg_Employee er = new Reg_Employee();
		er.setName("Arun");
		er.setSalay(10000);
		er.setBouns(5000);

		Contract_Employee ce = new Contract_Employee();
		ce.setName("Sai");
		ce.setPay_per_hour(199);
		ce.setContract_duration("9");
		t.commit();
		session.save(emp);
		session.save(er);
		session.save(ce);
		
		session.close();
		System.out.println();

	}

}
