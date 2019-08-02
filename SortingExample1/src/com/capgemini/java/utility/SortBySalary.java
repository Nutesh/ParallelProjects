package com.capgemini.java.utility;

import java.util.Comparator;

import com.capgemini.java.bean.Employee;

public class SortBySalary implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.getSalary() > e2.getSalary()) {
			return 1;
		} else if (e1.getSalary() < e2.getSalary()) {
			return -1;
		} else {
			return 0;
		}

	}

}
