package com.valuelabs.java8;

interface  TestInterface {
	abstract void test();
	
	  default void test1(){
		System.out.println("default menthod");
	}
	static void test2(){
		System.out.println("Static menthod");
	}
	

}
