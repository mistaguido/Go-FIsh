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
public enum Suit {
    HEARTS("Hearts"), CLUBS("Clubs"), SPADES("Spades"), DIAMONDS("Diamonds");
    
    private final String suit;
    
    Suit(String suit)
    {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
