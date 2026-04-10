package com.example.thornofkings.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Account {
    @Id
    private UUID userId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String email;
    private String passwordHash;

    @OneToOne
    @JoinColumn(name = "character_id")
    private Character character;
}
