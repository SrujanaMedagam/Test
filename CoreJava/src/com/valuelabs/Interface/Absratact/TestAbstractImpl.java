package com.valuelabs.Interface.Absratact;

public class TestAbstractImpl extends TestAbstract{
	private TestAbstractImpl(){
		System.out.println("TestAbstractImpl constructor");
	}

	@Override
	void test() {
		System.out.println("TestAbstract impl");
	}
	public static void main(String[] args){
		TestAbstract test=new TestAbstractImpl();
		test.test();
	}
}
