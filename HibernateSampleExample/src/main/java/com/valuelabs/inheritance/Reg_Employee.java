package com.valuelabs.inheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value="reg_emp")
@Table(name="Reg_Employee")
@AttributeOverrides({ @AttributeOverride(name="id" ,column=@Column(name="id")),
		@AttributeOverride(name="name" ,column=@Column(name="name"))})
public class Reg_Employee extends Employee{
	@Column
	private int salay;
	@Column
	private int bouns;
	public int getSalay() {
		return salay;
	}
	public void setSalay(int salay) {
		this.salay = salay;
	}
	public int getBouns() {
		return bouns;
	}
	public void setBouns(int bouns) {
		this.bouns = bouns;
	}
	
	

}
