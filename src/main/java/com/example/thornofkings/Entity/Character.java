package com.example.thornofkings.Entity;

import com.example.thornofkings.Enum.CharacterGender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Character {
    @Id
    private UUID id;

    private LocalDateTime createdAt;
    private String characterName;
    @Enumerated(EnumType.STRING)
    private CharacterGender characterGender;

    private int maxHealth;
    private int currentHealth;
    private LocalDateTime lastHealthUpdate;

    private int maxEnergy;
    private int currentEnergy;
    private LocalDateTime lastEnergyUpdate;

    private int stamina;
    private int strength;
    private int agility;
}
