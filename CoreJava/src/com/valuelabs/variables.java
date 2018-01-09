package com.valuelabs;

public class variables {
	static {
		System.out.println("ststic block");
	}
	int a=10;
	/*variables(int a){
		System.out.println();
	}*/
	//static int b=20;
	public void m1(){
		int a = 30;
		System.out.println(a);
		m2();
	}
	public void m2(){
		final int  b = 20;
		System.out.println(b);
		
	}
	public static void main(String args[]) throws ClassNotFoundException {
		variables v = new variables();
		System.out.println(v);
		v.m1();
		//Demo1 d = new Demo1();
		Class.forName("com.valuelabs.Demo1");
	}

}
