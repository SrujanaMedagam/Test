package com.valuelabs.comparator;

import java.util.HashMap;

public class HashmapTestFinal {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		Employee e1 = new Employee(2, "Sruja", 100);
		Employee e2 = new Employee(2, "Sruja", 100);
		Employee e3 = new Employee(2, "Sruja", 100);
		map.put(e1, 1);
		map.put(e2, 5);
		map.put(e3, 3);
		System.out.println(map);
		System.out.println(map.get(e1));

		/*System.out.println(map);

		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Employee Key = (Employee) it.next();
			System.out.println(map.get(e1));
		}*/

	}

}
