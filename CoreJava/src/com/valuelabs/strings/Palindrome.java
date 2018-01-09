package com.valuelabs.strings;

public class Palindrome {
	public static void main(String[] args){
		int  p=949,r,sum = 0,temp;
		temp=p;
		while(p>0){
		 r = p%10;
		 sum = (sum*10)+r;
		 p=p/10;
		 
		}
		if(temp==sum)
		System.out.println("Palindrome");
	}

}
