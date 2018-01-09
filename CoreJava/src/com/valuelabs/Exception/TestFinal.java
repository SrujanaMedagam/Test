package com.valuelabs.Exception;

public class TestFinal {
	public static void main(String[] args)throws ArithmeticException{
		Test2 t=new Test2();
		try {
			t.get();
			t.get1();
try{
				
			}catch(Exception e1){
				
			}
		} catch (ArithmeticException e) {
			
			System.out.println("Exception");
			e.printStackTrace();
		}catch(Exception e1){
			
			
		}
	}

}
