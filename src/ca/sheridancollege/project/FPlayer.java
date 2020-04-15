/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author REEEE
 */
public class FPlayer extends Player {

    private Deck playerDeck;
    private int score = 0;
    
    public FPlayer(String name, Deck deck) {
        super(name);
        this.playerDeck = deck;
    }

    public Deck getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(Deck playerDeck) {
        this.playerDeck = playerDeck;
    }
    
    public void addToScore(int i){
        score+=i;
    }
    
    public int getScore(){
        return score;
    }
    @Override
    public void play(){
        
    }
    
    
/*    
    public void play(ArrayList<FPlayer> playerlist) {
        Scanner sc = new Scanner(System.in);
        System.out.println("It's " + getPlayerID() + "'s turn.\nWhich player do you choose?");
        String ply;
        boolean findPlayer=false;
        //keep asking for player
        do{
            ply = sc.nextLine();
            if(isAPlayer(ply, playerlist)){findPlayer=true;}
            System.out.println("Couldn't find player, enter again");
        }while(findPlayer==false);
        
        System.out.println("What suit?");
        String suit;
        boolean findSuit=false;
        do{
            ply = sc.nextLine();
            if(isAPlayer(ply, playerlist)){findPlayer=true;}
            System.out.println("Couldn't find player, enter again");
        }while(findPlayer==false);
        
    }

    public boolean isAPlayer(String player, ArrayList<FPlayer> playerlist) {
        for (int i = 0; i < playerlist.size(); i++) {
            if (playerlist.get(i).getPlayerID().equals(player)) {
                return true;
            }
        }
        return false;
    }
*/
}
