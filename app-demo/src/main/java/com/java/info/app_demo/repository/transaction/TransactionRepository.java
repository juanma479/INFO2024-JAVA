package com.java.info.app_demo.repository.transaction;

import com.java.info.app_demo.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID>  {
    List<Transaction> findByType(String type);
}
