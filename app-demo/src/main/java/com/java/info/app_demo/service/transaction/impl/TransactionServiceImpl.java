package com.java.info.app_demo.service.transaction.impl;

import com.java.info.app_demo.domain.Transaction;
import com.java.info.app_demo.repository.transaction.TransactionRepository;
import com.java.info.app_demo.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl( TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        transaction.setIdTransaction(UUID.randomUUID());
        transaction.setDateTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getTransactionsById(UUID id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction updateTransaction(UUID id, Transaction transaction) {
        if (!transactionRepository.existsById(id)){
            throw new RuntimeException("No se encontró transacción.");
        }
        transaction.setIdTransaction(id);
        transaction.setDateTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(UUID id) {
        if (!transactionRepository.existsById(id)) {
            throw new RuntimeException("No se encontró transacción.");
        }
        transactionRepository.deleteById(id);
    }

    @Override
    public double getBalance() {
        double incomeTotal = transactionRepository.findByType("ingreso").stream().
                mapToDouble(Transaction::getAmount).sum();
        double expenseTotal = transactionRepository.findByType("gasto").stream().
                mapToDouble(Transaction::getAmount).sum();
        return incomeTotal - expenseTotal;
    }
}
