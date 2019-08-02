package com.capgemini.java.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

import com.capgemini.java.bean.Employee;
import com.capgemini.java.exception.EmployeeException;
import com.capgemini.java.service.EmployeeServiceImpl;
import com.capgemini.java.utility.SortByName;
import com.capgemini.java.utility.SortBySalary;

public class MainUI {
	public static void main(String[] args) {
		String continueChoice;
		boolean continueValue = false;
		Scanner scanner = new Scanner(System.in);

		do {

			System.out.println("1.Add employee");
			System.out.println("2.Display all employee");
			System.out.println("3.Sort");
			System.out.println("4.Delete Employee");
			System.out.println("5.Exit");

			EmployeeServiceImpl service = new EmployeeServiceImpl();

			int choice = 0;
			boolean choiceFlag = false;

			do {
				scanner = new Scanner(System.in);
				System.out.println("Enter input:");
				try {
					choice = scanner.nextInt();
					choiceFlag = true;

					boolean empFlag = false;

					String name = "";
					switch (choice) {

					case 1:
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter Employee name:");
							name = scanner.nextLine();
							try {
								empFlag=service.validateEmployeeName(name);
							} catch (EmployeeException e) {
								// TODO Auto-generated catch block
								System.err.println(e.getMessage());
							}
							//empFlag = true;
						} while (!empFlag);

						String mobileNo = "";
						boolean mobileFlag = false;
						do {
							scanner = new Scanner(System.in);
							System.out.println("Enter Employee mobile number:");
							try {
								mobileNo = scanner.next();
								service.ValidateMobileNo(mobileNo);
								mobileFlag = true;
							} catch (InputMismatchException e) {
								mobileFlag = false;
								System.err.println("Mobile number should be of 10 digits.");
							} catch (EmployeeException e) {
								mobileFlag = false;
								System.err.println(e.getMessage());
							}
						} while (!mobileFlag);

						scanner.nextLine();
						System.out.println("Enter Salary:");
						double salary = scanner.nextDouble();

						Employee employee = new Employee(0, name, mobileNo, salary);

						int genearatedId;
						try {
							genearatedId = service.addEmployee(employee);
							System.out.println("employee id is stored with given id: " + genearatedId);
						} catch (EmployeeException e) {
							// TODO Auto-generated catch block
							System.err.println(e.getMessage());
						}
						

						break;

					case 2:

						Map<Integer, Employee> emp;
						try {
							emp = service.getAllEmployee();
							Iterator<Integer> iterator = emp.keySet().iterator();
							while (iterator.hasNext()) {
								int id = iterator.next();
								Employee employeeData = emp.get(id);
								System.out.println(id + ": " + employeeData);
							}
						} catch (EmployeeException e) {
							// TODO Auto-generated catch block
							System.err.println(e.getMessage());
						}

						

						break;
					case 3:
						boolean newFlag = false;
						do {
							/*scanner = new Scanner(System.in);
							System.out.println("Enter input:");
							
								choice = scanner.nextInt();*/
								/*choiceFlag = true;

								
								TreeSet<Employee>emplist=null;
								emplist=new TreeSet<>(new SortByName());
*/
								/*switch (choice) {

								case 1:*/
							
									try {
										Map<Integer, Employee> empMap=service.getAllEmployee();
										Collection<Employee> collection=empMap.values();
										TreeSet<Employee>employeeList=new TreeSet<>();
										
										
										
										employeeList=new TreeSet<>(new SortBySalary());
										employeeList.addAll(collection);
										
										for (Iterator iterator = employeeList.iterator(); iterator.hasNext();) {
											Employee newEmployee = (Employee) iterator.next();
											System.out.println(newEmployee);
										}
									} catch (EmployeeException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
																		
								
								//}
						}while(newFlag);
						
						
						
						break;
					case 4:

						System.out.println("Enter employee id to delete");
						int id = scanner.nextInt();
						boolean status;
						try {
							status = service.deleteEmployee(id);
							if (status)
								System.out.println("Deleted successfully");
						} catch (EmployeeException e) {
							// TODO Auto-generated catch block
							System.err.println(e.getMessage());
						}
						
						break;

					case 5:
						System.out.println("Thank u, visit again");
						System.exit(0);
						break;
						
					case 6:
						System.out.println("serach");
						String inputName =scanner.next();
						Map<Integer, Employee> empMap;
						try {
							empMap = service.getAllEmployee();
							Collection<Employee> collection=empMap.values();
							TreeSet<Employee>employeeList=new TreeSet<>();
							boolean searchFlag=false;
							employeeList.addAll(collection);
							for (Iterator iterator = employeeList.iterator(); iterator.hasNext();) {
								Employee employee2 = (Employee) iterator.next();
								if(employee2.getName().equals(inputName)) {
									service.deleteEmployee(employee2.getEmpId());
									searchFlag=true;
									System.out.println("deleted");
									//System.out.println(employee2);
								}
								
							} 
							if (searchFlag==false) {
								System.out.println("name not found");
							}
						} catch (EmployeeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						break;
					default:
						System.out.println("input should be 1,2,3 or 4");
						choiceFlag = false;
						break;
					}
					

				} catch (InputMismatchException exception) {
					choiceFlag = false;
					System.err.println("input should contain only digits");
				}
			} while (!choiceFlag);

			do {
				scanner = new Scanner(System.in);
				System.out.println("do you want to continue again [yes/no]");
				continueChoice = scanner.nextLine();
				if (continueChoice.equalsIgnoreCase("yes")) {
					continueValue = true;
					break;
				} else if (continueChoice.equalsIgnoreCase("no")) {
					System.out.println("thank you");
					continueValue = false;
					break;
				} else {
					System.out.println("enter yes or no");
					continueValue = false;
					continue;
				}
			} while (!continueValue);

		} while (continueValue);
		scanner.close();
	}


}
