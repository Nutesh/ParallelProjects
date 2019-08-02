package com.capgemini.java.repository;

import java.util.Map;
import java.util.TreeMap;

import com.capgemini.java.bean.Employee;



public class EmployeeRepository {

	public static Map<Integer,Employee> employee=new TreeMap<>();
	
	static {
		
		employee.put(111, new Employee(111, "Nandini","9713757278",38000));
		employee.put(151, new Employee(151, "Nutesh","2713756778",35000));
		employee.put(141, new Employee(141, "Meghna","6713757278",32000));
		employee.put(131, new Employee(131, "Shreyasi","7813757278",30000));
		employee.put(121, new Employee(121, "Bhavya","8713757278",31000));
		
	}
	
	public static Map<Integer, Employee> getAllEmployee() {
		
		return employee;
	}
	public static void setVehicles(Map<Integer, Employee> employee) {
		EmployeeRepository.employee = employee;
	}


}
