package com.example.thornofkings.entity.character;

import com.example.thornofkings.entity.Account;
import com.example.thornofkings.entity.character.enums.CharacterGender;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue
    private Long id;
    private UUID exposedId;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private LocalDateTime createdAt;

    private String characterName;
    @Enumerated(EnumType.STRING)
    private CharacterGender characterGender;

    private int level;
    private int currentExperiencePoints;
    private int experiencePointsToLevel;

    @Embedded
    private Health health;
    @Embedded
    private Energy energy;
    @Embedded
    private BaseStats baseStats;

    public Character() {

    }

    public Character(Long id, UUID exposedId, Account account, LocalDateTime createdAt,
                     String characterName, CharacterGender characterGender, Health health, Energy energy,
                     int level, int currentExperiencePoints, int experiencePointsToLevel,
                     BaseStats baseStats) {
        this.id = id;
        this.exposedId = exposedId;
        this.account = account;
        this.createdAt = createdAt;
        this.characterName = characterName;
        this.characterGender = characterGender;
        this.health = health;
        this.energy = energy;
        this.level = level;
        this.currentExperiencePoints = currentExperiencePoints;
        this.experiencePointsToLevel = experiencePointsToLevel;
        this.baseStats = baseStats;
    }

    public Long getId() {
        return this.id;
    }

    public UUID getExposedId() {
        return this.exposedId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public CharacterGender getCharacterGender() {
        return this.characterGender;
    }

    public Health getHealth() {
        return this.health;
    }

    public Energy getEnergy() {
        return this.energy;
    }

    public BaseStats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(BaseStats baseStats) {
        this.baseStats = baseStats;
    }

    public int getCurrentExperiencePoints() {
        return this.currentExperiencePoints;
    }

    public void setCurrentExperiencePoints(int currentExperiencePoints) {
        this.currentExperiencePoints = currentExperiencePoints;
    }

    public int getExperiencePointsToLevel() {
        return this.experiencePointsToLevel;
    }

    public void setExperiencePointsToLevel(int experiencePointsToLevel) {
        this.experiencePointsToLevel = experiencePointsToLevel;
    }

    public void takeDamage(int damage) {
        this.health.takeDamage(damage);
    }

    public void regenerate() {
        this.health.regenerate();
        this.energy.regenerate();
    }
}
