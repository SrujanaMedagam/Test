package com.valuelabs.strings;

public class Test123 {

	public static void main(String[] args) {
		String str="Srujapa";
		String str1="Siujana";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=str1.charAt(i)){
				System.out.println(str.charAt(i));
			}
		}
	}

}
