package com.valuelabs.strings;

public class test000 {

	public static void main(String[] args) {
		String input="Srujana";
		String result = ""; 
		for (int i = 0; i < input.length(); i++) {
		 if(!result.contains(String.valueOf(input.charAt(i)))){
		 result+=input.charAt(i); }
		 
		 } System.out.println(result);
		 
	}

}
