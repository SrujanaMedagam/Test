package com.valuelabs.lms.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="employee")

public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String empId;
	@Column(name="firstName")
	private String firtsName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="fatherName")
	private String fatherName;
	@Column(name="address")
	private String address;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "EmployeePhone", joinColumns = { @JoinColumn(name = "empId") }, inverseJoinColumns = { @JoinColumn(name = "phoneId") })
	private Set<Phone> employeePhoneNumbers = new HashSet<Phone>(0);
/*	public Employee()
	{
		
	}
	public Employee(String empId, String firtsName, String lastName, String fatherName, String address,
			Set<Phone> employeePhoneNumbers) {
		super();
		this.empId = empId;
		this.firtsName = firtsName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.address = address;
		this.employeePhoneNumbers = employeePhoneNumbers;
	}*/
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getFirtsName() {
		return firtsName;
	}
	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<Phone> getEmployeePhoneNumbers() {
		return employeePhoneNumbers;
	}
	public void setEmployeePhoneNumbers(Set<Phone> employeePhoneNumbers) {
		this.employeePhoneNumbers = employeePhoneNumbers;
	}
	
	

}
