package com.valuelabs.restfull;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlAttribute;
import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement
public class Employee {
	private int eid;
	private int age;
	
	public void setAge(int age) {
		this.age = age;
	}
	@XmlAttribute
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public int getSalary() {
		return salary;
	}
	@XmlElement
	public int getAge() {
		return age;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private String name;
	private int salary;
	

}
