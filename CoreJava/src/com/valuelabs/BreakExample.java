package com.valuelabs;

public class BreakExample {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i == 2&& j == 2) {
					//break;
					//continue;
				}
				System.out.println("j is:" + j);
			}

			System.out.println(i);
		}
	}
}