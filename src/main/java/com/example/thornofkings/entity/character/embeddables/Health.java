package com.example.thornofkings.entity.character.embeddables;

import jakarta.persistence.Embeddable;

import java.time.Duration;
import java.time.LocalDateTime;

@Embeddable
public class Health {
    private int currentHealth;
    private int maxHealth;
    private LocalDateTime lastHealthUpdate;

    public Health() {

    }

    public Health(int currentHealth, int maxHealth, LocalDateTime lastHealthUpdate) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.lastHealthUpdate = lastHealthUpdate;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public LocalDateTime getLastHealthUpdate() {
        return lastHealthUpdate;
    }

    public void setLastHealthUpdate(LocalDateTime lastHealthUpdate) {
        this.lastHealthUpdate = lastHealthUpdate;
    }

    public void regenerate() {
        long minutes = Duration.between(lastHealthUpdate, LocalDateTime.now()).toMinutes();
        int regen = (int) minutes;

        this.currentHealth = Math.min(maxHealth, currentHealth + regen);
        this.lastHealthUpdate = LocalDateTime.now();
    }

    public void takeDamage(int damage) {
        this.currentHealth = Math.max(0, this.currentHealth - damage);
    }
}
