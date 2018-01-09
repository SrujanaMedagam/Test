package com.valuelabs.array;

public class SinglrtonClass {
	static SinglrtonClass s=null;
	private SinglrtonClass(){
		System.out.println("SinglrtonClass constructor calling");
	}
	static final SinglrtonClass getSinglrtonClass(){
		if(s==null){
		
		 s=new SinglrtonClass();
		}
		return s;
	}
}
