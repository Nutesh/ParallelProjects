package com.capgemini.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.capgemini.bank.utility.DBConnection;

import com.capgemini.bank.bean.Account;
import com.capgemini.bank.bean.Transaction;

public class BankDaoImpl implements BankDao {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	boolean status = false;
	int row = -1;
	int accountNo = 0;
	int authorId=0;
	@Override
	public int insertAccount(Account account) {
		try (Connection connection = DBConnection.getConnection();) {

			statement = connection.prepareStatement("select accountSeq.NEXTVAL from dual");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				accountNo = resultSet.getInt(1);
				//statement = connection.prepareStatement("insert into book values(?,?,?)");
				statement.setInt(1, accountNo);
			//	statement.setString(2, );
			//	statement.setDouble(3,);
				row = statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountNo;
	}

	@Override
	public int insertTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Transaction> showAllTransactions(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

}
