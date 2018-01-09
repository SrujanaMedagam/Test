package com.valuelabs.Exception;

public class ThrowsTest {
	static void validate(int i){
		if(i<18){
			throw new ArithmeticException("Not valid age for vote");
		}else{
			System.out.println("Eligible for vote.");
		}
	}
	public static void main(String args[]){
		validate(17);
	}
	
}
