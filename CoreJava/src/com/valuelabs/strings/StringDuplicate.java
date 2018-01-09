package com.valuelabs.strings;

public class StringDuplicate {

	public static void main(String[] args) {
		/*
		 * StringBuffer str = new StringBuffer("Srujana"); String
		 * input="Srujadvfsfaaana"; String result = ""; for (int i = 0; i <
		 * input.length(); i++) {
		 * if(!result.contains(String.valueOf(input.charAt(i)))){
		 * result+=input.charAt(i); }
		 * 
		 * } System.out.println(result);
		 * 
		 */

		/*
		 * for (int i=0;i<str.length()-1;i++){ for (int
		 * j=i+1;j<str.length();j++){ if (str.charAt(i)==str.charAt(j))
		 * str.deleteCharAt(j); } } System.out.println(str); ;
		 */

		String s = "srujana srujana srujana";
		String []str =s.split(" ");
		System.out.println("No of word:"+str.length);
		int distinct = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				count++;
			}
			

			/*for (int j = 0; j < s.length(); j++) {

				if (s.charAt(i) == s.charAt(j)) {
					distinct++;

				}
			}
			System.out.println(s.charAt(i) + "--" + distinct);
			String d = String.valueOf(s.charAt(i)).trim();
			s = s.replaceAll(d, "");
			distinct = 0;
			i--;*/
		}
		int countString = 0;
		for(int i=0;i<str.length;i++){
			for(int j=0;j<str.length;j++){
				countString++;
				
			}
			System.out.println("repeted words:"+str[0]+""+countString);
			
		}
		System.out.println("No.fo words :"+count);

	}
}