package com.valuelabs.comparator;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class EmployeeSort {

	public static void main(String[] args) {
		/*
		TreeSet<Employee> t=new TreeSet<Employee>(new EmployeeSalaryCompare());
		t.add(new Employee(1,"Srujana",1000));
		t.add(new Employee(5,"Sonu",5000));
		t.add(new Employee(9,"sai",6000));
		t.add(new Employee(2,"Chandu",3000));
		for(Employee e:t){
			System.out.println(e);
		}
		TreeSet<Employee> t1=new TreeSet<Employee>(new EmployeeNAmeCompare());
		t1.add(new Employee(1,"Srujana",1000));
		t1.add(new Employee(5,"Sonu",5000));
		t1.add(new Employee(9,"sai",6000));
		t1.add(new Employee(2,"Chandu",3000));
		for(Employee e:t1){
			System.out.println(e);
		}*/
		/*TreeMap<Employee,String> t2=new TreeMap<Employee,String>(new EmployeeNAmeCompare());
		t2.put(new Employee(1,"Srujana",1000),"1");
		t2.put(new Employee(5,"Sonu",5000),"1");
		t2.put(new Employee(9,"sai",6000),"1");
		t2.put(new Employee(2,"Chandu",3000),"1");
		Set<Employee> keys=t2.keySet();
		for(Employee e:keys){
			System.out.println(e);
		}*/
		
		TreeSet<Employee> t=new TreeSet<Employee>();
		t.add(new Employee(1,"Srujana",1000));
		t.add(new Employee(5,"Sonu",5000));
		t.add(new Employee(9,"sai",6000));
		t.add(new Employee(2,"Chandu",3000));
		t.add(new Employee(5,"Chandu",3000));
		for(Employee e:t){
			System.out.println(e);
		}
		
		
	}

}
