package com.cg.services;

import java.util.List;

import com.cg.entities.Return;
import com.cg.entities.Transaction;

public interface IReturnService {
	
	public List<Return> getAllReturnDetails();
	
	public Return addrecordtoreturn(int temp);
	
	public List<Integer> getTransaction(int id);
//
//	public String addTransaction(Transaction t);
//
//	public List<Transaction> getAllTransactions();
	
//	public Return checkstatus(int orderid);
	

	

//	public List<Return> getreturngoods();



}
