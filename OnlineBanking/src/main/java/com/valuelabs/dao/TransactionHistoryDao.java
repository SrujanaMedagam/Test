package com.valuelabs.dao;

import java.util.List;

public interface TransactionHistoryDao {
	public List<String> transactionHistory(String accountDetails);

}
