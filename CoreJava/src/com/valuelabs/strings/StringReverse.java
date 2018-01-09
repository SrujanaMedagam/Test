package com.valuelabs.strings;

public class StringReverse {
	public static void main(String[] args) { 
		String str="Srujana medagam hyd";
		String result="";
		//Reverse String in java
		/*for(int i=str.length()-1;i>=0;i--){
			result+=str.charAt(i);
		}
		System.out.println(result);
		
*/
		
		//Reverse each word in Java
		 String[] words = str.split(" ");
         
	        String reverseString = "";
	         
	        for (int i = 0; i < words.length; i++) 
	        {
	            String word = words[i];
	             
	            String reverseWord = "";
	             
	            for (int j = word.length()-1; j >= 0; j--) 
	            {
	                reverseWord = reverseWord + word.charAt(j);
	            }
	             
	            reverseString = reverseString + reverseWord + " ";
	        }
	         
	        System.out.println(reverseString);
	         
}
}

