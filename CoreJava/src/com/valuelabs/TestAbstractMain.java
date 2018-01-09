package com.valuelabs;

public class TestAbstractMain extends TestAbsract {
	@Override
	void test() throws ArithmeticException{
		System.out.println("name:"+str);
	System.out.println("test()");
		
	}

	public static void main(String args[])  {
		TestAbstractMain tb = new TestAbstractMain();
		tb.test();
		tb.set();
	}

	
}
