package com.valuelabs.strings;

class NoRepetiveCharLast {
	public static void main(String... a) {

		String s = "abcdabcdabcdabcd";
		int distinct = 0;

		for (int i = 0; i < s.length(); i++) {

			for (int j = 0; j < s.length(); j++) {

				if (s.charAt(i) == s.charAt(j)) {
					distinct++;

				}
			}
			System.out.println(s.charAt(i) + "--" + distinct);
			String d = String.valueOf(s.charAt(i)).trim();
			s = s.replaceAll(d, "");
			distinct = 0;

		}
	}
}
