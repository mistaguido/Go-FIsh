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
import java.util.*;

public class FGame extends Game {
    static ArrayList<FPlayer> playerList = new ArrayList();
    static Scanner sc = new Scanner(System.in);

    public FGame(String name) {
        super(name);
    }

    @Override
    public void play() {

        ArrayList<FCard> reserveList = new ArrayList();
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                FCard card = new FCard(suit, value);
                reserveList.add(card);
            }
        }
        ReserveDeck reserveDeck = new ReserveDeck(reserveList);

        //players
        System.out.println("Enter number of players (more than 2, less than 4): ");
        int noOfPlayers = askForNoPlayer();
        //players
        System.out.println("Enter player names");
        for (int i = 0; i < noOfPlayers; i++) {
            String playerName = askForName();
            playerList.add(new FPlayer(playerName, new Deck(new ArrayList())));
        }

        reserveDeck.distributeToPlayers(playerList, noOfPlayers);

        System.out.println("Game will begin now");

        Books book = new Books();
        int books = 0;

        do {
            for (FPlayer ply : playerList) {
                System.out.println(ply.getPlayerID() + "'s turn");
                int plyIndex = askForPlayerIndex(playerList, ply.getPlayerID()); //ask which player
                Value guessRank = askRank();
                Deck opDeck = playerList.get(plyIndex).getPlayerDeck();
                boolean boolCatch = false;
                //loop through opponent's cards to see if they have a card of that rank
                for(int i = 0; i < opDeck.getCards().size(); i++){
                    //match
                    FCard opCard = opDeck.getCards().get(i);
                    //if there's a match
                    if (guessRank == opCard.getValue()){
                        opDeck.moveCardToDeck(i, ply.getPlayerDeck());
                        book.getBooks(ply.getPlayerDeck());
                        System.out.println("Catch");
                        boolCatch = true;
                    }
                }
                if (!boolCatch){
                    System.out.println("Go fish");
                    if(reserveDeck.getSize() > 0){
                        reserveDeck.moveCardToDeck(0, opDeck);
                    }else{
                        System.out.println("There are no more cards on the table");
                    }
                }
            }
            books = book.getNoBooks();
        } while (books <= 13);
        
        declareWinner();
    }

    public Value askRank() {
        try {
            System.out.println("What ranks?");
            Value ranks[] = new Value[13];
            int i = 0;
            for(Value value : Value.values()){
                ranks[i]=value;
                i++;
            }
            
            for(int j = 0; j < ranks.length; j++){
                System.out.println("["+j+"]" + ranks[j].toString());
            }
            
            int choice = sc.nextInt();
            
            if (choice == (int) choice){
                if (choice >= 0 && choice < ranks.length){
                    return ranks[choice];
                }
            }
            return askRank();
        } catch (NumberFormatException e) {
            return askRank();
        }
    }

    public int askForPlayerIndex(ArrayList<FPlayer> playerList, String plyName) {
        try {
            System.out.println("Which player do you choose?");
            int plyindex=0;
            for (int i = 0; i < playerList.size(); i++) {
                if (!playerList.get(i).getPlayerID().equals(plyName)){
                System.out.println("[" + i + "]" + playerList.get(i).getPlayerID());}else{
                    plyindex=i;
                }
            }
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == (int) choice) {
                if ((choice >= 0 && choice < playerList.size()) && choice != plyindex) {
                    return choice;
                }
            }
            return askForPlayerIndex(playerList, plyName);
        } catch (NumberFormatException e) {
            return askForPlayerIndex(playerList, plyName);
        }
    }

    public int askForNoPlayer() {
        try {
            int x = Integer.parseInt(sc.nextLine());
            if (x == (int) x) {
                if (x > 1) {
                    if (x > 4) {
                        System.out.println("Too many players");
                        return askForNoPlayer();
                    } else {
                        return x;
                    }
                }
            }
            return askForNoPlayer();
        } catch (NumberFormatException e) {
            return askForNoPlayer();
        }
    }

    public String askForName() {
        try {
            String nam = sc.nextLine();
            return nam;
        } catch (Exception e) {
            return askForName();
        }
    }

    @Override
    public void declareWinner() {
        int highestScore=0;
        String plyID="";
        for(FPlayer ply : playerList){
            if (ply.getScore() > highestScore){
                highestScore = ply.getScore();
                plyID=ply.getPlayerID();
            }
        }
        System.out.println("Player " + plyID + " wins with " + highestScore + " books");
        System.exit(0);
    }
}
