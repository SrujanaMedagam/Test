package com.valuelabs.inheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue(value="contract_emp")
@Table(name="Contract_Employee")
@AttributeOverrides(value = { @AttributeOverride(name="id" ,column=@Column(name="id")),
		@AttributeOverride(name="name" ,column=@Column(name="name"))})
public class Contract_Employee extends Employee{
	@Column
	private float pay_per_hour; 
	@Column
    private String contract_duration;
	public float getPay_per_hour() {
		return pay_per_hour;
	}
	public void setPay_per_hour(float pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}
	public String getContract_duration() {
		return contract_duration;
	}
	public void setContract_duration(String contract_duration) {
		this.contract_duration = contract_duration;
	}  
    
    

}
