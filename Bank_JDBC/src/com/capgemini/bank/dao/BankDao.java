package com.capgemini.bank.dao;

import java.util.List;

import com.capgemini.bank.bean.Account;
import com.capgemini.bank.bean.Transaction;

public interface BankDao {

	int insertAccount(Account account);
	
	int insertTransaction(Transaction transaction);
	
	int updateAccount(Account account);
	
	List<Transaction> showAllTransactions(Transaction transaction);
	
}
