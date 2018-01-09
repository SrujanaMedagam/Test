package com.valuelabs.comparator;

import java.util.Comparator;

public class EmployeeSalaryCompare implements Comparable<Employee>{

	@Override
	public int compareTo(Employee e1) {
		
		return 0;
	}

	/*@Override
	public int compare(Object o1, Object o2) {
		Employee s1 = (Employee) o1;
		Employee s2 = (Employee) o2;

		if (s1.salary == s2.salary)
			return 0;
		else if (s1.salary > s2.salary)
			return 1;
		else
			return -1;
		
	}*/

}
