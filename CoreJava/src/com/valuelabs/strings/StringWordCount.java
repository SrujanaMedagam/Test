package com.valuelabs.strings;

public class StringWordCount {
	public static void main(String srgs[]){
	String str =" java is good. java is best ";
	int count = 0;
	for(int i=0;i<str.length()-1;i++){
		if((str.charAt(i)==' ') && (str.charAt(i+1)!=' ')){
			count++;
		}
			
	}
	System.out.println(count);
	}

}
