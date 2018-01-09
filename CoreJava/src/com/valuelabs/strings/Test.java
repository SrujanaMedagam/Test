package com.valuelabs.strings;

public class Test {
	public static void main(String arfs[]) {
		String str = "10001101";
		String res = "";
		char ch[] = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			
			if (ch[i] == '0' ) {
					res=res+ch[i];
		}
		}
		for(int j=0;j<ch.length;j++){
			if(ch[j]=='1'){
				res = res+ch[j];
			}
		}
		System.out.println(res);
	}

}
