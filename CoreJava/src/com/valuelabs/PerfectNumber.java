package com.valuelabs;

public class PerfectNumber {
	public static void main(String args[]){
		
		int num=27,result=0;
		/*for(int i=1;i<num;i++){
			if(num%i==0){
				result=result+i;
			}
			
		}																		//PerfectNumber Code
		
		System.out.println(result);
		if(num==result){
			System.out.println("Given number is a perfect number");
		}*/
		
		int count=0;
		for(int i=2;i<num;i++){
			if(num%i==0){
				count=count+1;
				if(count>0)
					break;
			}
			
				
			System.out.println(count);
		}
		if(count==0){
		System.out.println("Given number is Prime number");
		}
	}
}
