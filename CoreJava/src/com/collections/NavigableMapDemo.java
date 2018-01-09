package com.collections;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDemo {

  public static void main(String[] args) {
	 // Map<String,Integer> navigableMap=new TreeMap<String, Integer>();

	NavigableMap<String,Integer> navigableMap=new TreeMap<String, Integer>();

	navigableMap.put("X", 500);
	navigableMap.put("B", 600);
	navigableMap.put("A", 700);
	navigableMap.put("T", 800);
	navigableMap.put("Y", 900);
	navigableMap.put("Z", 200);
	System.out.println(navigableMap);

	System.out.printf("Descending Set  : %s%n",navigableMap.descendingKeySet());

	System.out.printf("Floor Entry  : %s%n",navigableMap.floorEntry("k"));

	System.out.printf("First Entry  : %s%n",navigableMap.firstEntry());

	System.out.printf("Last Key : %s%n",navigableMap.lastKey());

	System.out.printf("First Key : %s%n",navigableMap.firstKey());

	System.out.printf("Original Map : %s%n",navigableMap);

	System.out.printf("Reverse Map : %s%n",navigableMap.descendingMap());
 
  }

}