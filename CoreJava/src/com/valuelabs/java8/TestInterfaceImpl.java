package com.valuelabs.java8;

public class TestInterfaceImpl implements TestInterface {
	@Override
	public void test() {
		System.out.println("test method from interface impl");
	}
	
	public static void main(String args[]){
		TestInterface it = new TestInterfaceImpl();
		it.test1();
		TestInterface.test2();
		it.test();
		
	}

}
