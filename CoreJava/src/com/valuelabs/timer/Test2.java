package com.valuelabs.timer;

public class Test2 extends test1{
	static{
		System.out.println("static1 from test2");
	}
	
	static{
		System.out.println("static2 from test2");
	}
	{
		
		System.out.println("instatnt2");
	}
	public static void main(String args[]){
		Test2 t = new Test2();
	}

}
