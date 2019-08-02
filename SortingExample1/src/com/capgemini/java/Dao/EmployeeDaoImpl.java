package com.capgemini.java.Dao;

import java.util.Map;

import com.capgemini.java.bean.Employee;
import com.capgemini.java.repository.EmployeeRepository;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public int addEmployee(Employee employee) {
		EmployeeRepository.employee.put(employee.getEmpId(), employee);
		return employee.getEmpId();
	}

	
	public Map<Integer, Employee> getAllEmployee() {

		return EmployeeRepository.getAllEmployee();
	}

	public boolean deleteEmployee(int id) {

		boolean status = false;
		Employee employee = getAllEmployee().remove(id);
		if (employee != null)
			status = true;
		return status;
	}
	
}
