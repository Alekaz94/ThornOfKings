package com.example.thornofkings.entity.item.embeddables;

import jakarta.persistence.Embeddable;

@Embeddable
public class ItemStats {
    private int stamina;
    private int strength;
    private int defence;
    private int agility;
    private int speed;
    private int armor;

    public ItemStats() {

    }

    public ItemStats(int stamina, int strength, int defence, int agility, int speed, int armor) {
        this.stamina = stamina;
        this.strength = strength;
        this.defence = defence;
        this.agility = agility;
        this.speed = speed;
        this.armor = armor;
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

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
