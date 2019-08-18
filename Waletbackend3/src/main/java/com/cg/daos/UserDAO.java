package com.cg.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Transaction;
import com.cg.entities.User1;
@Repository
public interface UserDAO extends JpaRepository<User1, Integer> {

}
