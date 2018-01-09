package com.valuelabs.Exception;

public class TestFinally {
	public static void main(String args[]){
		try{
			int i=5/0;
			
		}catch(Exception e){
			System.out.println(e);
			
		}finally{
			System.out.println("finally");
		}
		System.out.println("rest of the code");
	}

}
