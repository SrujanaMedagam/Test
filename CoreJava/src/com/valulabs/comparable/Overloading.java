package com.valulabs.comparable;

public class Overloading {
	public void add(double d) {
		System.out.println("x");
	}

	public String add(String str) {
		System.out.println("string");
		return str;
	}

	

	public static void main(String[] args) {
		Overloading o = new Overloading();
		o.add("Srujana");
		o.add(1043535343+"sar");
		o.add(5.0f);

	}

}
