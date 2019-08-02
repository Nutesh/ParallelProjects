package com.capgemini.java.Dao;

import java.util.Map;

import com.capgemini.java.bean.Employee;

public interface IEmployeeDao {

	public int addEmployee(Employee employee);

	public Map<Integer, Employee> getAllEmployee();

	public boolean deleteEmployee(int id);
}
