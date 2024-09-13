package com.java.info.app_demo.controller;

import com.java.info.app_demo.domain.Transaction;
import com.java.info.app_demo.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/api/v1/transactions")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {

        Transaction newTransaction = transactionService.addTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransaction);
    }

    @GetMapping("api/v1/transactions")
    public ResponseEntity<List<Transaction>> getTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/api/v1/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable UUID id) {
        Optional<Transaction> transaction = transactionService.getTransactionsById(id);
        return transaction.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/api/v1/transactions/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable UUID id,
                                                         @RequestBody Transaction transaction) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, transaction);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("/api/v1/transactions/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable UUID id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/v1/transactions/balance")
    public ResponseEntity<Double> getBalance() {
        Double balance = transactionService.getBalance();
        return ResponseEntity.ok(balance);
    }

}
