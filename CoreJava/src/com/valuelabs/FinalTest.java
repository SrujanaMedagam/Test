package com.valuelabs;

abstract class FinalTest {
	FinalTest(){
		System.out.println("FinalTest constructor");
	}
	static void test(){
		System.out.println("static method from final class");
	}
	abstract void test2();
}
