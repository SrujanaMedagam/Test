package com.valuelabs.strings;

public class Amstrong {
	public static void main(String[] args){
		int num=153,temp,r,sum = 0,res;
		temp=num;
		while(temp>0){
			res=temp%10;
			sum=sum+(res*res*res);
			temp=temp/10;
			
		}
		System.out.println(sum);
	}

}
