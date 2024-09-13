package com.java.info.app_demo.service.transaction;

import com.java.info.app_demo.domain.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionService {

    Transaction addTransaction(Transaction transaction);

    List<Transaction> getAllTransactions();

    Optional<Transaction> getTransactionsById(UUID id);

    Transaction updateTransaction(UUID id, Transaction transaction);

    void deleteTransaction(UUID id);

    double getBalance();
}
