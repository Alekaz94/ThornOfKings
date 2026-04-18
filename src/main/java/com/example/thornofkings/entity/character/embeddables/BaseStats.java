package com.example.thornofkings.entity.character.embeddables;

import jakarta.persistence.Embeddable;

@Embeddable
public class BaseStats {
    private int stamina;
    private int strength;
    private int defence;
    private int agility;
    private int speed;

    public BaseStats() {

    }

    public BaseStats(int stamina, int strength, int defence, int agility, int speed) {
        this.stamina = stamina;
        this.strength = strength;
        this.defence = defence;
        this.agility = agility;
        this.speed = speed;
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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
