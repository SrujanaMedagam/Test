package com.valuelabs;

public class B extends A{
	B(){
		super(4);
		System.out.println("From Constructor B");
	}
	{
		System.out.println("Fron instance block");
	}

	public static void main(String[] args) {

		B b=new B();
	}

}
