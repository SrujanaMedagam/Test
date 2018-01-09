package com.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HashMapTest {
	public static void main(String agrs[]){

		HashMap map=new HashMap();
		map.put("1", "a");
		map.put("3", "f");
		map.put("5", "v");
		map.put("123", "b");
		map.put("123", "x");
		System.out.println(map);
		/*Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			System.out.println("Key:"+key +"  Value:"+map.get(key));
		}*/
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Map.Entry  entry = (Map.Entry) it.next();
			System.out.println(entry.getKey()+ " : " +entry.getValue());
		}
		
		
	}

}
