package com.example.thornofkings.entity;

import com.example.thornofkings.entity.character.Character;
import com.example.thornofkings.entity.item.Item;
import jakarta.persistence.*;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"character_id", "item_id"})
)
public class CharacterItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character character;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private boolean equipped;
    private int quantity;
    private int equippedQuantity;

    public CharacterItem() {

    }

    public CharacterItem(Character character, Item item, boolean equipped, int quantity, int equippedQuantity) {
        this.character = character;
        this.item = item;
        this.equipped = equipped;
        this.quantity = quantity;
        this.equippedQuantity = equippedQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    public int getEquippedQuantity() {
        return equippedQuantity;
    }

    public void setEquippedQuantity(int equippedQuantity) {
        this.equippedQuantity = equippedQuantity;
    }
}
