package com.valuelabs.strings;

public class ReplaceWithX {

	public static void main(String[] args) {
		String str1 = "34345645678912";
		String str2 = "";
		for (int i = 0; i < str1.length() - 4; i++) {
			str2 = str2 + "X";
		}
		str2 = str2 + str1.substring(str1.length() - 4, str1.length());
		System.out.println(str2);
	}
}