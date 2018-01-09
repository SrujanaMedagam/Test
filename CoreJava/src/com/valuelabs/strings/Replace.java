package com.valuelabs.strings;

public class Replace {

	public static void main(String[] args) {
		String str="asdfghjklpoiuyasdfghj";
		for(int i=0;i<str.length();i++){
			if(i%2==0){
				str= str.replace(str.charAt(i), '$');
			}
		}
		System.out.println(str);
	}

}
