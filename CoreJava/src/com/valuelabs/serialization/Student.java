package com.valuelabs.serialization;

import java.io.Serializable;

public class Student  implements Serializable{
	
	/**
	 * 
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	int id;
	  String name;
	static String contact;
	 Address address;
	
	public Student(int id, String name, String contact,Address address) {
		
		super();
		System.out.println("Srujana");
		System.out.println("Srujana");
		
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address=address;
	}
	

}
