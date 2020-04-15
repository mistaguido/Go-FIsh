/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author REEEE
 */
public class Deck extends GroupOfCards{
    
    private final ArrayList<FCard> cards;
    
    public Deck(ArrayList<FCard> cards)
    {
        super(cards.size());
        this.cards = cards;
    }
    
    public ArrayList<FCard> getCards() {
        return cards;
    }
    
    public void removeCard(int index){
        cards.remove(index);
        setSize(getSize()-1);
    }
    
    public void addCard(FCard card)
    {
        cards.add(card);
        setSize(getSize()+1);
    }
    
    //moves to different deck
    public void moveCardToDeck(int index, Deck deck){
        deck.addCard(cards.get(index));
        removeCard(index);
    }
    
    //tostring
    @Override
    public String toString(){
        String strToReturn = "";
        for(int i = 0; i < cards.size(); i++){
            strToReturn+=cards.get(i).toString()+"\n";
        }
        return strToReturn;
    }
    
    @Override
    public void shuffle(){
        Collections.shuffle(cards);
    }

}
