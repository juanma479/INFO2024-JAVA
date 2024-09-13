package com.java.info.app_demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transaction {

    @Id
    private UUID idTransaction;

    private String type; // Tipo de transacción :Ingreso o Gasto
    private String description;
    private Double amount;
    private LocalDateTime dateTime;

    // Constructor sin parámetros (requerido por JPA)
    public Transaction() {}

    public Transaction(String type, String description,
                       Double amount) {
        this.idTransaction = UUID.randomUUID();
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
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
