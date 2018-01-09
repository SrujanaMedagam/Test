package com.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("7");
		set.add("1");
		set.add("4");
		set.add("9");
		set.add("9");

		Iterator it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
