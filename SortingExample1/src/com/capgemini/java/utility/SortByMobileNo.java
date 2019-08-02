package com.capgemini.java.utility;

import java.util.Comparator;

import com.capgemini.java.bean.Employee;

public class SortByMobileNo implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) 
	{
		return e1.getMobileNo().compareTo(e2.getMobileNo());
	}

}
