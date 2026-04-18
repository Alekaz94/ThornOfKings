package com.example.thornofkings.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String name;
    private String email;
    private String passwordHash;

    public Account() {
    }

    public Account(LocalDateTime createdAt, LocalDateTime updatedAt, String name, String email, String passwordHash) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
