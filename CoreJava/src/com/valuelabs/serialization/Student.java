package com.valuelabs.serialization;

import java.io.Serializable;

public class Student  implements Serializable{
	/**
	 * 
	 */
	int id;
	  String name;
	 String contact;
	
	public Student(int id, String name, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
	}
	

}
