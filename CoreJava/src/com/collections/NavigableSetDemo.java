package com.collections;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class NavigableSetDemo {

	public static void main(String[] args) {
		// Map<String,Integer> navigableMap=new TreeMap<String, Integer>();

		StringBuffer bf = new StringBuffer("Sunayana");
		NavigableSet set = new TreeSet();

		set.add("kdfsld");
		set.add(bf);
		// set.add(4);
		System.out.println(set);
		System.out.println(set.descendingSet());
		System.out.println(set.first());
	}

}