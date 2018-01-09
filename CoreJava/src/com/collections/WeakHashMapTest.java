package com.collections;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapTest {
	public static void main(String args[]){
		TestApp t=new TestApp();
		//WeakHashMap map=new WeakHashMap();
		HashMap map=new HashMap(); 
		map.put(t, "Srujana");
		map.put(2, 5);
		System.out.println(map);
		t=null;
		System.gc();
		System.out.println(map);
	}

}
