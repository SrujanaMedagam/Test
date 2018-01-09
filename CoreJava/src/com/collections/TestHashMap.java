package com.collections;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

	static String getValue(Map<String, Object> m, String key) {
		String value = "";
		for (Map.Entry e : m.entrySet()) {
			if (e.getKey().toString().equalsIgnoreCase(key)) {
				return e.getValue().toString();
			} else {
				if (e.getValue() instanceof Map) {
					return getValue((Map<String, Object>) e.getValue(), key);
				}
			}
		}
		return value;
	}

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		Map map1 = new HashMap();
		map1.put("5", "5");
		map1.put("6", "6");
		Map map2 = new HashMap();
		map2.put("8", "8");
		map2.put("9", "9");
		Map map3 = new HashMap();
		map3.put("11", "11");
		map2.put("10", map3);
		map1.put("7", map2);
		map.put("4", map1);

		System.out.println(getValue(map, "4"));

	}

}
