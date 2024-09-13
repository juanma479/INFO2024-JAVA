package com.java.info.app_demo.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private UUID idTransaction;
    private String type; // Tipo de transacción :Ingreso o Gasto
    private String description;
    private Double amount;
    private LocalDateTime dateTime;

    public Transaction(UUID idTransaction, String type, String description,
                       Double amount, LocalDateTime dateTime) {
        this.idTransaction = idTransaction;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public UUID getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(UUID idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
