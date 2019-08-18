package com.cg.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.Transaction;
import com.cg.entities.User1;
@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer>{
@Query("select t from Transaction t where t.transactionId=?1")
public Transaction gettransaction(int id);


@Query("select t from Transaction t where t.customer=?1")
public List<Transaction> getAllTransactionByUser(User1 user);
}
