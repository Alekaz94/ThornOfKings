package com.example.thornofkings.entity.item;

import com.example.thornofkings.entity.CharacterItem;
import com.example.thornofkings.entity.item.enums.ItemRarity;
import com.example.thornofkings.entity.item.enums.ItemSlot;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private ItemSlot slot;
    @Enumerated(EnumType.STRING)
    private ItemRarity rarity;
    @Embedded
    private ItemStats itemStats;
    private boolean equippable;
    private boolean stackable;

    @OneToMany(mappedBy = "item")
    private List<CharacterItem> characterItems;

    public Item() {

    }

    public Item(String name, ItemSlot slot, ItemRarity rarity, ItemStats itemStats, boolean equippable, boolean stackable) {
        this.name = name;
        this.slot = slot;
        this.rarity = rarity;
        this.itemStats = itemStats;
        this.equippable = equippable;
        this.stackable = stackable;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemSlot getSlot() {
        return slot;
    }

    public void setSlot(ItemSlot slot) {
        this.slot = slot;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public void setRarity(ItemRarity rarity) {
        this.rarity = rarity;
    }

    public ItemStats getItemStats() {
        return itemStats;
    }

    public void setItemStats(ItemStats itemStats) {
        this.itemStats = itemStats;
    }

    public boolean isEquippable() {
        return equippable;
    }

    public void setEquippable(boolean equippable) {
        this.equippable = equippable;
    }

    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof Item)) {
            return false;
        }

        Item item = (Item) o;
        return id != null && id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
