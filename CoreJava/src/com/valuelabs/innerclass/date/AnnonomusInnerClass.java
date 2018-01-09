package com.valuelabs.innerclass.date;

abstract class AnnonomusInnerClass {
	int i=10; 
	abstract void test();
	public static void main(String args[]){
		AnnonomusInnerClass an=new AnnonomusInnerClass(){
			void test(){
				System.out.println(i);
				System.out.println("innerclass executed");
			}
		};
		an.test();
	}
	

}
