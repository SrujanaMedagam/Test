package com.valuelabs.Exception;

public class CustromException {
	static void validate(int age) throws SmallAgeException{
		
		if(age<18){
			throw new SmallAgeException("Age less than 18");
		}
	}

	public static void main(String[] args) {
		try{
			validate(15);
			
		}catch(Exception se){
			System.out.println("Excepton : "+se);
		}
		System.out.println("rest of the code");
		int i=8;
		System.out.println(i);
	}

}
