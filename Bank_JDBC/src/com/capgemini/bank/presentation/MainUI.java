package com.capgemini.bank.presentation;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.bank.bean.Account;
import com.capgemini.bank.bean.Transaction;
import com.capgemini.bank.exception.BankException;
import com.capgemini.bank.service.BankServiceImpl;

public class MainUI {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BankServiceImpl serviceImpl = new BankServiceImpl();
		String transactionNo = "";
		
		
		
		do {
		System.out.println("***********************Welcome to XYZ Bank*************************");
		System.out.println(
				"1.Create Account \n2.Check Balance\n3.Deposit\n4.Withdraw\n5.Fund Transfer\n6.Print Last 10 Transactions\n7.Print All Transactions\n8.Exit");
		int userInput = 0;
		userInput = scanner.nextInt();
		switch (userInput) {
		case 1: {
			
			String firstName,middleName,lastName,gender;
			String mobileNo = "";
			int pin;
			
			System.out.println("Please enter user details : \n");
			boolean firstNameValidated = false;
            do {
            	scanner = new Scanner(System.in);
            	System.out.println("Enter First Name : ");
                firstName = scanner.nextLine();
                    
                    try {
                    	
                            firstNameValidated = serviceImpl.validateName(firstName);
                    } catch (BankException e) {
                            System.err.println(e.getMessage());
                    }
            } while(!firstNameValidated);
            
            boolean middleNameValidated = false;
            do {
                    scanner= new Scanner(System.in);
                    System.out.println("Enter Middle Name : ");
                    middleName = scanner.nextLine();
                    try {
                            middleNameValidated = serviceImpl.validateMiddleName(middleName);
                    } catch (BankException e) {
                            System.out.println(middleNameValidated);
                            System.err.println(e.getMessage());
                    }
            } while(!middleNameValidated);
            
            boolean lastNameValidated = false;
            do {
                    scanner=new Scanner(System.in);
                    System.out.println("Enter Last Name : ");
                    lastName = scanner.nextLine();
                    try {
                            lastNameValidated = serviceImpl.validateName(lastName);
                    } catch (BankException e) {
                            System.err.println(e.getMessage());
                    }
            } while(!lastNameValidated);
           
			boolean mobileValidated = false ;
			do {
				scanner=new Scanner(System.in);
				System.out.println("Enter MobileNo. : ");
				 mobileNo = scanner.nextLine();
				try {
					mobileValidated = serviceImpl.validateMobile(mobileNo);
				} catch (BankException e) {
					System.err.println(e.getMessage());
				}
			} while (!mobileValidated);
			
			boolean genderValidated = false ;
			do {
				scanner=new Scanner(System.in);
				System.out.println("Enter Gender : ");
				gender = scanner.next();
				try {
					genderValidated = serviceImpl.validateGender(gender);
					} catch (BankException e) {
					System.err.println(e.getMessage());
				}
			} while (!genderValidated);
			
			boolean pinValidated = false;
            do {
                    scanner= new Scanner(System.in);
                    System.out.println("Enter Pin : ");
                    pin = scanner.nextInt();
                    try {
                            pinValidated = serviceImpl.validatePin(pin);
                    } catch (BankException e) {
                            System.out.println(pinValidated);
                            System.err.println(e.getMessage());
                    }
            } while(!pinValidated);
			Account account = new Account(firstName, middleName, lastName, mobileNo, gender,pin);
			try {
				
				long accountNo = serviceImpl.createAccount(account);
				System.out.println("Your account is created with account no : "+accountNo);
			} catch (BankException e) {
				System.err.println(e.getMessage());
			}
		}
			break;

		case 2: {
			long accountNo = 0;
			boolean accountValidated = false;
			do {
				
				try {
					scanner=new Scanner(System.in);
					System.out.println("Enter Account : ");
					accountNo = scanner.nextLong();
					String accountName = serviceImpl.getAccountName(accountNo);
					System.out.println("Account Name : "+accountName);
					if (!accountName.equals("")) {
						accountValidated = true;
					}
				} catch (NullPointerException e) {
					System.out.println(accountValidated);
					System.err.println("This Account doesn't exists");
				} catch (InputMismatchException e) {
					System.err.println("Please enter numeric value");
				}
			} while (!accountValidated);
			try {
				
				double balance = serviceImpl.showBalance(accountNo);
				System.out.println("Your Balance is : " + balance);
			}
			catch (InputMismatchException e) {
				System.err.println("Please enter a valid account number");
			}
			catch (BankException e) {
				System.err.println(e.getMessage());
			}
		}
			break;
			
		case 3:{
			long accountNo = 0;
			boolean accountValidated = false;
			do {
				
				try {
					System.out.println("Enter Account No. : ");
					accountNo = scanner.nextLong();
					String accountName = serviceImpl.getAccountName(accountNo);
					System.out.println("Account Name : "+accountName);
					if (!accountName.equals("")) {
						accountValidated = true;
					}
				} catch (NullPointerException e) {
					System.out.println(accountValidated);
					System.err.println("This Account doesn't exists");
				} catch (InputMismatchException e) {
					scanner.next();
					System.out.println(accountValidated);
					System.err.println("Please enter numeric value");
				}
			} while (!accountValidated);
			double amount = 0;
			 boolean amountValidated = false;
             do {
                     
                     
                     try {
                    	 scanner= new Scanner(System.in);
                     	System.out.println("Enter Amount : ");
                         amount = scanner.nextDouble();
                             amountValidated = serviceImpl.validateAmount(amount,accountNo,"credit");
                       } catch (BankException e) {
                             System.out.println(amountValidated);
                             System.err.println(e.getMessage());
                     }
                     catch (InputMismatchException e) {
                     	scanner.next();
                         System.out.println(amountValidated);
                         System.err.println("Please enter numeric value");
                 }
             } while(!amountValidated);
			String type = "credit";
			
			Transaction transaction = new Transaction( accountNo, type, amount, accountNo);
			try {
				transactionNo = serviceImpl.deposit(transaction);
				System.out.println("Your account is credited with Rs : "+amount+
						"\n And your transaction id is : "+transactionNo);
			} catch (BankException e) {
				System.err.println(e.getMessage());
			}
			
				
			}
		
			break;
			
		case 4:{
			long accountNo = 0;
			boolean accountValidated = false;
			do {
				
				try {
					scanner = new Scanner(System.in);
					System.out.println("Enter Account : ");
					accountNo = scanner.nextLong();
					String accountName = serviceImpl.getAccountName(accountNo);
					System.out.println("Account Name : "+accountName);
					if (!accountName.equals("")) {
						accountValidated = true;
					}
				} catch (NullPointerException e) {
					System.out.println(accountValidated);
					System.err.println("This Account doesn't exists");
				} catch (InputMismatchException e) {
					System.err.println("Please enter numeric value");
				}
			} while (!accountValidated);
			double amount = 0;
			 boolean amountValidated = false;
            do {
                    
                    
                    try {
                    	scanner = new Scanner(System.in);
                    	System.out.println("Enter Amount : ");
                        amount = scanner.nextDouble();
                            amountValidated = serviceImpl.validateAmount(amount,accountNo,"debit");
                    } catch (BankException e) {
                            System.out.println(amountValidated);
                            System.err.println(e.getMessage());
                    }
                    catch (InputMismatchException e) {
                        System.err.println("Please enter numeric value");
                }
            } while(!amountValidated);
			String type = "debit";
			
			Transaction transaction = new Transaction( accountNo, type, amount, accountNo);
			
			try {
				transactionNo = serviceImpl.withdraw(transaction);
				System.out.println("Your account is debited with Rs : "+amount+
						"\n And your transaction id is : "+transactionNo);
			} catch (BankException e) {
				System.err.println(e.getMessage());
			}
				
			}
		
			break;
			
			case 5:{
			long accountNo = 0,destinationAccountNo =0;
			boolean accountValidated = false;
			do {
				
				try {
					scanner = new Scanner(System.in);
					System.out.println("Enter Account : ");
					accountNo = scanner.nextLong();
					String accountName = serviceImpl.getAccountName(accountNo);
					System.out.println("Account Name : "+accountName);
					if (!accountName.equals("")) {
						accountValidated = true;
					}
				} catch (NullPointerException e) {
					System.out.println(accountValidated);
					System.err.println("This Account doesn't exists");
				} catch (InputMismatchException e) {
					System.err.println("Please enter numeric value");
				}
			} while (!accountValidated);
			boolean recieverAccountValidated = false;
			do {
				
				try {
					System.out.println("Enter reciever account no. :");
					destinationAccountNo = scanner.nextLong();
					String accountName = serviceImpl.getAccountName(destinationAccountNo);
					System.out.println("Account Name : "+accountName);
					if (!accountName.equals("")) {
						recieverAccountValidated = true;
					}
				} catch (NullPointerException e) {
					
					System.err.println("This Account doesn't exists");
				} catch (InputMismatchException e) {
					System.err.println("Please enter numeric value");
				}
			} while (!recieverAccountValidated);
			double amount = 0;
			 boolean amountValidated = false;
            do {
                    
                    
                    try {
                    	scanner = new Scanner(System.in);
                    	System.out.println("Enter Amount : ");
                        amount = scanner.nextDouble();
                            amountValidated = serviceImpl.validateAmount(amount,accountNo,"debit");
                    } catch (BankException e) {
                            System.out.println(amountValidated);
                            System.err.println(e.getMessage());
                    }
                    catch (InputMismatchException e) {
                    System.err.println("Please enter numeric value");
                }
            } while(!amountValidated);
			String type = "debit";
			
			
			Transaction transaction = new Transaction( accountNo, type, amount, destinationAccountNo);
			try {
				transactionNo = serviceImpl.fundTransfer(transaction);
				System.out.println("Your have transferred Rs : "+amount+ " to "+ serviceImpl.getAccountName(destinationAccountNo)+
						"\n And your transaction id is : "+transactionNo);
			} catch (BankException e) {
				System.err.println(e.getMessage());
			}
				
			
		}
			break;
		case 6:
		{
			long accountNo = 0;
			boolean accountValidated = false;
			do {
				
				try {
					scanner = new Scanner(System.in);
					System.out.println("Enter Account : ");
					accountNo = scanner.nextLong();
					String accountName = serviceImpl.getAccountName(accountNo);
					System.out.println("Account Name : "+accountName);
					if (!accountName.equals("")) {
						accountValidated = true;
					}
				} catch (NullPointerException e) {
					System.err.println("This Account doesn't exists");
				} catch (InputMismatchException e) {
					System.err.println("Please enter numeric value");
				}
			} while (!accountValidated);
			List<Transaction> transactions = null;
			try {
				transactions = serviceImpl.showAllTransactions(accountNo);
			} catch (InputMismatchException | BankException e) {
				System.err.println(e.getMessage());
			}
			int count=0;
			for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext() && count <10;) {
				Transaction transaction = (Transaction) iterator.next();
				System.out.println(transaction);
				count++;
			}
		}
			break;
			
		case 7:{
			long accountNo = 0;
			boolean accountValidated = false;
			do {
				
				try {
					scanner = new Scanner(System.in);
					System.out.println("Enter Account : ");
					accountNo = scanner.nextLong();
					String accountName = serviceImpl.getAccountName(accountNo);
					System.out.println("Account Name : "+accountName);
					if (!accountName.equals("")) {
						accountValidated = true;
						}
				} catch (NullPointerException e) {
					System.out.println(accountValidated);
					System.err.println("This Account doesn't exists");
				} catch (InputMismatchException e) {
					System.err.println("Please enter numeric value");
				}
			} while (!accountValidated);
			List<Transaction> transactions = null;
			try {
				transactions = serviceImpl.showAllTransactions(accountNo);
				for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext();) {
					Transaction transaction = (Transaction) iterator.next();
					System.out.println(transaction);
				}
			} catch (InputMismatchException | BankException e) {
				System.err.println(e.getMessage());
			}
			
		}
			break;
			
		
			
		case 8:{
			scanner.close();
			System.exit(0);
		}
		
		
		default:
			System.err.println("Please enter input between 1 to 9");
			break;
		}
		}while(true);
	}
}
