/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author REEEE
 */
public class ReserveDeck extends Deck {
    
    public ReserveDeck(ArrayList cards)
    {
        super(cards);
    }
    
    public void distributeToPlayers(ArrayList<FPlayer> players, int noOfPlayers)
    {
        int noPlayers = noOfPlayers;
        int cardsPerPlayer = (int)Math.floor((double) getSize() / noPlayers);
        System.out.println("cards per player: " + cardsPerPlayer);
        shuffle();
        
        players.forEach((ply) -> {   
            for (int i = 0; i < cardsPerPlayer; i++){
                moveCardToDeck(0, ply.getPlayerDeck());
            }
        });
    }
}
