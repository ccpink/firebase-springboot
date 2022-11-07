package com.example.springbootfirebasedemo.entity;

public class Card {

    private int cardId;
    private String cardName;
    private int damage;
    private int manaCost;

    public int getTargeting() {
        return targeting;
    }

    public void setTargeting(int targeting) {
        this.targeting = targeting;
    }

    private int targeting;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
}
