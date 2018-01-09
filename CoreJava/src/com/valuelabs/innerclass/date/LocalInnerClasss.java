package com.valuelabs.innerclass.date;

public class LocalInnerClasss {
	void test(){
		class TestTest{
			void set1(){
				System.out.println("set method from TestTest");
			}
			
		}
		System.out.println("generweall");
		TestTest t =new TestTest();
		t.set1();
	}
	public static void main(String arfs[]){
		LocalInnerClasss lc = new LocalInnerClasss();
		lc.test();
		
	}

}
