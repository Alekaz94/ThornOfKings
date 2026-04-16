package com.example.thornofkings.entity.character;

import jakarta.persistence.Embeddable;

@Embeddable
public class BaseStats {
    private int stamina;
    private int strength;
    private int agility;
    private int intellect;

    public BaseStats() {

    }

    public BaseStats(int stamina, int strength, int agility, int intellect) {
        this.stamina = stamina;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }
}
