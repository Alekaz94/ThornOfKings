package com.example.thornofkings.entity;

import com.example.thornofkings.entity.character.Character;
import jakarta.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private Long id;
    private Long silver = 0L;
    private Long gold = 0L;
    private Long diamond = 0L;

    @OneToOne
    @JoinColumn(name = "character_id")
    private Character character;

    public Wallet(){

    }

    public Wallet(Long silver, Long gold, Long diamond, Character character) {
        this.silver = silver;
        this.gold = gold;
        this.diamond = diamond;
        this.character = character;
    }

    public Long getId() {
        return id;
    }

    public Long getSilver() {
        return silver;
    }

    public void setSilver(Long silver) {
        this.silver = silver;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public Long getDiamond() {
        return diamond;
    }

    public void setDiamond(Long diamond) {
        this.diamond = diamond;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
        if(character != null && character.getWallet() != this) {
            character.setWallet(this);
        }
    }
}
