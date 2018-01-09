package com.valuelabs.strings;

public class MissedCharFromString {

	public static void main(String[] args) {
		String str="ace";
		String str1="[a-f]";
		for(int i=0;i<str.length();i++){
				if(str.indexOf(i)!=str1.indexOf(i)){
					
					System.out.println(str1.charAt(i));
					
					
				}
			}
			
		}
	}


