package com.valuelabs;

public class Address {
	private int aid;
	private String state;
	private Address(){
		
	}
	
	private Address(int aid, String state) {
		super();
		this.aid = aid;
		this.state = state;
	}
	
	
	
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", state=" + state + "]";
	}

	
}
