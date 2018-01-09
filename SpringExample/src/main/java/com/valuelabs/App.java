/*package com.valuelabs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		Employee obj = (Employee) context.getBean(Employee.class);

		obj.setName("test");
		obj.setId(3);
		obj.show();
		System.out.println(obj.getName());

		Employee obj1 = (Employee) context.getBean(Employee.class);
		
		System.out.println(obj1.getName());

	}
}
 */