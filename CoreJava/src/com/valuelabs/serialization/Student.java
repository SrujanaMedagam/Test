package com.valuelabs.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {

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
	transient int id;
	transient String pwd;
	String name;
	String contact;
	Address address;

	public Student(int id, String pwd, String name, String contact, Address address) {

		super();
		this.id = id;
		this.pwd = pwd;

		this.name = name;
		this.contact = contact;

		this.address = address;
	}

	private void writeObject(ObjectOutputStream fos) throws IOException {
		fos.defaultWriteObject();
		String password = "abc" + pwd;
		fos.writeObject(password);
		System.out.println("WriteObject method" + password);

	}

	

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		String word = (String) ois.readObject();
		System.out.println(word);
		this.pwd = word.substring(3);
		System.out.println(pwd);
		System.out.println("readObject method");
	}

}
