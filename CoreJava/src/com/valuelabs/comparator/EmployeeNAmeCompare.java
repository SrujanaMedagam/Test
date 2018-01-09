package com.valuelabs.comparator;

import java.util.Comparator;

public class EmployeeNAmeCompare implements Comparator<Employee> {

	@Override
	public int compare(Employee s1, Employee s2) {
		
		return s1.getName().compareToIgnoreCase(s2.getName());
	}

}
