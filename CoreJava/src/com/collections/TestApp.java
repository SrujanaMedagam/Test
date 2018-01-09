package com.collections;

public class TestApp {
	

	@Override
	public String toString() {
		return "TestApp";
	}

	public void finalize(){
		System.out.println("finalize wmthod called");
	}

}
