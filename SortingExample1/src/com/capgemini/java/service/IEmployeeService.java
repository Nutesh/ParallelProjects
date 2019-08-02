package com.capgemini.java.service;

import java.util.Map;

import com.capgemini.java.bean.Employee;
import com.capgemini.java.exception.EmployeeException;

public interface IEmployeeService {
	
	public int addEmployee(Employee employee) throws EmployeeException;

	public Map<Integer, Employee> getAllEmployee() throws EmployeeException;

	public boolean deleteEmployee(int id) throws EmployeeException;
	
	public Map<Integer, Employee> getEmployeeDetails() throws EmployeeException;
}
