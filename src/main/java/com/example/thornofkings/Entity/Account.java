package com.example.thornofkings.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Account {
    @Id
    private UUID id;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String name;
    private String email;
    private String passwordHash;
}
