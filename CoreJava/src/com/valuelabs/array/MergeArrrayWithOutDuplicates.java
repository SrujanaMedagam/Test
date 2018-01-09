package com.valuelabs.array;

import java.util.HashSet;
import java.util.Set;

public class MergeArrrayWithOutDuplicates {
	public static void main(String args[]) {
		int arr1[] = { 1, 3, 5, 7 };
		int arr2[] = { 2, 4, 5, 6, 7, 9 };
		Set set = new HashSet();
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		for (int j = 0; j < arr2.length; j++) {
			set.add(arr2[j]);
		}
		System.out.println(set);
	}

}
