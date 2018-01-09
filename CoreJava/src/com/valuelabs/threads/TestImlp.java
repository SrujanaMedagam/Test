package com.valuelabs.threads;

public class TestImlp implements Test3{

	@Override
	public void get() {
		System.out.println("Test method");
		
	}
	public static void main(String[] args){
		
		TestImlp ti = new TestImlp();
		ti.get();
	}
	

}
