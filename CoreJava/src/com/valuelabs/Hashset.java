package com.valuelabs;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
	public static void main(String args[]){
		/*Employee e= new Employee();
		e.setName("Srujana");
		Employee e1=new Employee();
		System.out.println("433333333333");
		HashSet set=new HashSet();
		set.add(e);
		System.out.println("@@@@@@@@@@@@@");
		set.add(e1);
		System.out.println("&&&&&&&&&&&&&");
		e1.setName("Srujana");
		System.out.println(e);
		System.out.println(e1);
		System.out.println(set.size());
		System.out.println(e.getName());
		System.out.println(e1.getName());*/
		
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(5);
		
		for(int i=0;i<=10;i++){
			hs.add(i);
		}
		System.out.println(hs.size());
		
		
		//hs.forEach(i -> System.out.println(i));
		/*Iterator it = hs.iterator();
		while(it.hasNext()){
			System.out.println(it.next());;
				it.remove();
				
			}
		
		for(int s:hs){
			System.out.println(s);
			hs.remove(s);
		}
		*/

		}

}