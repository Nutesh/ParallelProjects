package com.capgemini.java.bean;

public class Employee implements Comparable<Employee> {

	private int empId;
	private String name;
	private String mobileNo;
	private double salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(int empId, String name, String mobileNo, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", mobileNo=" + mobileNo + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee e) {

		if (this.empId > e.empId) {
			return 1;
		} else if (this.empId < e.empId) {
			return -1;
		} else {
			return 0;
		}

	}

}
