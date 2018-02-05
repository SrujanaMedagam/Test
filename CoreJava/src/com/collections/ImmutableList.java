package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ImmutableList {
	public static void main(String args[]){
		List al=new ArrayList();
		al.add(1);
		al.add(2);
		al.add(3);
	//	al.remove(2);
		/*Iterator it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			
		}*/
		ArrayList a12 = (ArrayList) Collections.unmodifiableList(al);
		Iterator it = a12.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			
		}
		a12.remove(2);
	}

}
