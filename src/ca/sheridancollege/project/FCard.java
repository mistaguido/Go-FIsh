/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author REEEE
 */
public class FCard extends Card {

    private final Suit suit;

    private final Value value;

    public FCard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }
    
    public FCard() {
        this.suit = Suit.CLUBS;
        this.value = Value.DEUCE;
    }

    @Override
    public String toString() {
        return "Suit: " + suit.getSuit() + " Value: " + value.toString();
    }
}
