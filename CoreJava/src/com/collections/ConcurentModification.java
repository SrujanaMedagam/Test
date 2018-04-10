package com.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurentModification {
	public static void main(String[] args) {

		//ConcurrentHashMap
		Map<String,String> myMap = new ConcurrentHashMap<String,String>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		System.out.println("contains:"+myMap.containsKey("5"));
		for(String s:myMap.keySet()){
			System.out.println(s);
		}
		
		System.out.println("ConcurrentHashMap before iterator: "+myMap);
		Iterator<String> it = myMap.keySet().iterator();

		while(it.hasNext()){
			String key = it.next();
			if(key.equals("3")) myMap.put(key+"new", "new3");
		}
		System.out.println("ConcurrentHashMap after iterator: "+myMap);

		//HashMap
		myMap = new HashMap<String,String>();
		myMap.put(null, "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		System.out.println(myMap.containsKey(null));
		System.out.println("HashMap before iterator: "+myMap);
		Iterator<String> it1 = myMap.keySet().iterator();
	Set s =myMap.entrySet();
		Iterator r =s.iterator();
		while(r.hasNext()){
			Map.Entry em = (Entry) r.next();
			System.out.print(em.getKey()+" ");
			System.out.println(em.getValue());
			
		}

		while(it1.hasNext()){
			String key = it1.next();
			if(key.equals("4")) myMap.remove("4");
		}
		System.out.println("HashMap after iterator: "+myMap);
	}

}
