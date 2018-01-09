package com.valuelabs;

public class AbstractTest extends FinalTest{

	
	AbstractTest(){
		System.out.println("AbstractTest constructor");
	}
	@Override
	void test2() {
		System.out.println("test2 from absract");
		
	}
	
	public static void main(String args[]){
		FinalTest a=new AbstractTest();
		a.test2();
		
		FinalTest.test();
	}
	
	

}

