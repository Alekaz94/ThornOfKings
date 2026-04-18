package com.example.thornofkings.entity.character;

import com.example.thornofkings.entity.Account;
import com.example.thornofkings.entity.CharacterItem;
import com.example.thornofkings.entity.Wallet;
import com.example.thornofkings.entity.character.embeddables.BaseStats;
import com.example.thornofkings.entity.character.embeddables.Energy;
import com.example.thornofkings.entity.character.embeddables.Health;
import com.example.thornofkings.entity.character.enums.CharacterGender;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
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
    private int trainingPoints;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CharacterItem> characterItems = new ArrayList<>();

    @OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
    private Wallet wallet;

    @Embedded
    private Health health;
    @Embedded
    private Energy energy;
    @Embedded
    private BaseStats baseStats;

    public Character() {

    }

    public Character(Account account, LocalDateTime createdAt,
                     String characterName, CharacterGender characterGender, Health health, Energy energy,
                     int level, int currentExperiencePoints, int experiencePointsToLevel,
                     BaseStats baseStats) {
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

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
        if(wallet != null && wallet.getCharacter() != this) {
            wallet.setCharacter(this);
        }
    }

    public void takeDamage(int damage) {
        this.health.takeDamage(damage);
    }

    public void regenerate() {
        this.health.regenerate();
        this.energy.regenerate();
    }

    public void addItem(CharacterItem item) {
        characterItems.add(item);
        item.setCharacter(this);
    }

    public void removeItem(CharacterItem item) {
        characterItems.remove(item);
        item.setCharacter(null);
    }
}
