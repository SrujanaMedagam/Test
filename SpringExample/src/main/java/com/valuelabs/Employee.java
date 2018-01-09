package com.valuelabs;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(value="prototype")
public class Employee {
	private int id;
	private String name;
	private Address address;

	public Employee(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public Employee() {

	}
	
	 public Employee(int id, String name, Address address) { super(); this.id
	 = id; this.name = "Srujana"; this.address = address; }
	 

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void init() {
		System.out.println("init() method");

	}

	public void destroy() {
		System.out.println("destroy() method");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	void show() {
		System.out.println(id + "  " + name + " " + address);
	}

}
