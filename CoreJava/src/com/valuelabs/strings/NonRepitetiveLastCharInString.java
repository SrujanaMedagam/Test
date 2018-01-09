package com.valuelabs.strings;

public class NonRepitetiveLastCharInString {

	public static void main(String[] args) {
		String str = "Harinir";
		String result = "";
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			if (count < 2) {
				result = result + str.charAt(i);
			}
			count = 0;
		}
		System.out.println(result);
		System.out.println(result.charAt(result.length()-1));
	}

}
