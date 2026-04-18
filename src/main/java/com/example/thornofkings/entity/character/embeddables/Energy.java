package com.example.thornofkings.entity.character.embeddables;

import jakarta.persistence.Embeddable;

import java.time.Duration;
import java.time.LocalDateTime;

@Embeddable
public class Energy {
    private int currentEnergy;
    private int maxEnergy;
    private LocalDateTime lastEnergyUpdate;

    public Energy() {

    }

    public Energy(int currentEnergy, int maxEnergy, LocalDateTime lastEnergyUpdate) {
        this.currentEnergy = currentEnergy;
        this.maxEnergy = maxEnergy;
        this.lastEnergyUpdate = lastEnergyUpdate;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public LocalDateTime getLastEnergyUpdate() {
        return lastEnergyUpdate;
    }

    public void setLastEnergyUpdate(LocalDateTime lastEnergyUpdate) {
        this.lastEnergyUpdate = lastEnergyUpdate;
    }

    public void regenerate() {
        long minutes = Duration.between(lastEnergyUpdate, LocalDateTime.now()).toMinutes();
        int regen = (int) minutes;

        this.currentEnergy = Math.min(maxEnergy, currentEnergy + regen);
        this.lastEnergyUpdate = LocalDateTime.now();
    }
}
