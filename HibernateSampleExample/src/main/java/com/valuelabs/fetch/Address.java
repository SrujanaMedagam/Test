package com.valuelabs.fetch;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table
public class Address {
	@Id
	@Column
	private int ano;
	@Column
	private String street;
	@Column
	private String state;
//	@OneToMany(fetch = (FetchType.EAGER), cascade = CascadeType.ALL)
//	@JoinColumn(name = "oid")
//	@Fetch(FetchMode.JOIN)
//	private Set<Owners> owners;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	/*public Set<Owners> getOwners() {
		return owners;
	}
	public void setOwners(Set<Owners> owners) {
		this.owners = owners;
	}
	@Override
	public String toString() {
		return "Address [ano=" + ano + ", street=" + street + ", state=" + state + ", owners=" + owners
				+ ", getStreet()=" + getStreet() + ", getState()=" + getState() + ", getAno()=" + getAno()
				+ ", getOwners()=" + getOwners() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}*/
	
	

}
