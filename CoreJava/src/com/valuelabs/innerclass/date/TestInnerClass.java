package com.valuelabs.innerclass.date;

public class TestInnerClass {
	private int i=10;
	public void test(){
		System.out.println("test method from TestInnerClass");
	}
	class MenberInnerClass{
		public void testMember(){
			System.out.println(i);
			System.out.println("testMember method  from memberInnerClass");
		}
		
	}
	public static void main(String args[]){
		TestInnerClass ti = new TestInnerClass();
		MenberInnerClass mi = ti.new MenberInnerClass();
		mi.testMember();
		ti.test();
	}

}
