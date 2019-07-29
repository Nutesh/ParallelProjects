package com.capgemini.bank.service;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import com.capgemini.bank.bean.Account;
import com.capgemini.bank.bean.Transaction;
import com.capgemini.bank.dao.BankDao;
import com.capgemini.bank.dao.BankDaoImpl;
import com.capgemini.bank.exception.BankException;

public class BankServiceImpl implements BankService {

	
	double newBalance = 0, oldBalance = 0;
	BankDao dao = new BankDaoImpl();

	



	

	public String getAccountName(long accountNo) throws NullPointerException, InputMismatchException {
		String name = "";
		name=dao.getAccountName(accountNo);
		return name;
	}

	public boolean validateMobile(String mobile) throws BankException, InputMismatchException {
		String mobilePtn = "[6-9]{1}[0-9]{9}";
		if (!Pattern.matches(mobilePtn, mobile)) {
			throw new BankException("Mobile number should be in digits and have exactly 10 digits");
		} else
			return true;
	}

	public boolean validateMiddleName(String name) throws BankException {
		String nameRegEx = "[A-Za-z- ]{1,20}";
		if (!Pattern.matches(nameRegEx, name)) {
			throw new BankException("first letter should be capital and length must be in between 5 to 10\n"
					+ "if you don't have middle name then press \"-\" \n");
		} else
			return true;
	}

	public boolean validateName(String name) throws BankException {
		String nameRegEx = "[a-zA-Z ]{1,20}";
		if (!Pattern.matches(nameRegEx, name)) {
			throw new BankException("please enter a valid name and length must be more than 20 letters \n");
		} else
			return true;
	}

	public boolean validateGender(String name) throws BankException {

		if (name.equalsIgnoreCase("Male") || name.equalsIgnoreCase("Other") || name.equalsIgnoreCase("Female")) {
			return true;

		} else
			throw new BankException("please enter male female or other \n");
	}

	public boolean validateAmount(double amount, long accountNo,String type) throws BankException, InputMismatchException {
		boolean amountValidated = false; 
		if(type == "debit")
		 {
			 if (amount <= 0 || amount > 20000) {
			
				throw new BankException("Amount must be greater than 0 and not more than 2000");
			}
			/*if (BankDAO.accounts.get(accountNo).getBalance() < amount) {
				throw new BankException("Your balance is less than entered amount");
			}*/
			amountValidated = true;
		 }
		 else if(type == "credit")
		 {
			 if (amount <= 0 || amount > 20000) {
			
				throw new BankException("Amount must be greater than 0 and not more than 2000");
			}
			amountValidated = true;
		 }
		return amountValidated;
	}

	

	@Override
	public List<Transaction> showAllTransactions(long accountNo) throws BankException, InputMismatchException {
		List<Transaction> transactions = new LinkedList<Transaction>();
		transactions=dao.showAllTransactions(accountNo);
		return transactions;
	}

	@Override
	public long createAccount(Account account) throws BankException {
		
		return dao.insertAccount(account);
	}

	@Override
	public boolean deposit(Transaction transaction) throws BankException {
		double sourceAccountBalance = dao.showBalance(transaction.getDestinationAccountNo());
		sourceAccountBalance =+ transaction.getAmount();
		int deposited = dao.updateBalance(transaction.getAccountNo(), sourceAccountBalance);
		if(deposited <0) {
			return false;
		}
		else
			return true;
		
	}

	@Override
	public boolean fundTransfer(Transaction transaction) throws BankException {
		BankServiceImpl serviceImpl = new BankServiceImpl();
		if(serviceImpl.withdraw(transaction) && serviceImpl.deposit(transaction)) {
			return true;
		}
		else 
			return false;
	}

	@Override
	public boolean withdraw(Transaction transaction) throws BankException {
		double sourceAccountBalance = dao.showBalance(transaction.getAccountNo());
		sourceAccountBalance =- transaction.getAmount();
		int deposited = dao.updateBalance(transaction.getAccountNo(), sourceAccountBalance);
		if(deposited <0) {
			return false;
		}
		else
			return true;
	}

	@Override
	public double showBalance(long accountNo) throws BankException, InputMismatchException {
		
		return dao.showBalance(accountNo);
	}

	

}
