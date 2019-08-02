package com.capgemini.java.service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.java.Dao.EmployeeDaoImpl;
import com.capgemini.java.Dao.IEmployeeDao;
import com.capgemini.java.bean.Employee;
import com.capgemini.java.exception.EmployeeException;

public class EmployeeServiceImpl implements IEmployeeService {

	EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

	public int addEmployee(Employee employee) throws EmployeeException {

		int empId = (int) (Math.random() * 1000);

		employee.setEmpId(empId);
		return employeeDao.addEmployee(employee);
	}

	public Map<Integer, Employee> getAllEmployee() throws EmployeeException {

		return employeeDao.getAllEmployee();
	}

	public boolean deleteEmployee(int id) throws EmployeeException {
		boolean status = employeeDao.deleteEmployee(id);
		if (status)
			return status;
		else {

			throw new EmployeeException("Customer Id doen't exists to delete");

		}
	}

	public boolean validateEmployeeName(String vehicleName) throws EmployeeException {

		boolean resultFlag = false;
		String nameRegEx = "[A-Z]{1}[a-zA-Z ]{4,}";

		if (!Pattern.matches(nameRegEx, vehicleName)) {

			throw new EmployeeException("first letter should be capital and length should be greater than 5 digits");

		} else {
			resultFlag = true;
		}
		return resultFlag;
	}

	public boolean ValidateMobileNo(String mobileNo) throws EmployeeException {
		String mobile = String.valueOf(mobileNo);
		Pattern nameptn = Pattern.compile("^[7-9]{1}[0-9]{9}$");
		Matcher match = nameptn.matcher(mobile);
		if (!match.matches())
			throw new EmployeeException("Mobile number is invalid.Please try again.");
		else
			return true;

	}

	@Override
	public Map<Integer, Employee> getEmployeeDetails() throws EmployeeException {
	
		return null;
	}
	

}
