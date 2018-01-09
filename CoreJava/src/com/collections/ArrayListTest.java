package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		
		list.add("1");
		list.add(null);
		list.add(null);
		list.add("2");
		list.add("3");
		list.add(1, "5");
ArrayList<String> list1=new ArrayList<String>();
		
		list1.add("1"); 
		list1.add("2");
		list1.add("3");
		list1.add(1, "9");
		list.addAll(list1);
		Iterator it = list.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
			
		}
		
	}

}
