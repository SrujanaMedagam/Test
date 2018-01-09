package com.valulabs.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComparableTest {
	public static void main(String args[]){
		List set=new ArrayList();
		set.add(new Student(1,"srujana","AP"));
		set.add(new Student(3,"srujana","AP"));
		set.add(new Student(5,"srujana","AP"));
		set.add(new Student(3,"srujana","AP"));
				
		System.out.println(set);
		Collections.sort(set);
		System.out.println(set);
		
	}

}
