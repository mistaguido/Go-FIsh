/*
    Every round, this class is called upon to find books in a player's card. When a book is found, that player wins.
 */
package ca.sheridancollege.project;

/**
 *
 * @author REEEE
 */
public class Books {
    //when this reaches 13, the game is finished.
    private int noBooks;
    
    public Books(){
        noBooks = 0;
    }
    
    private void bookScored(){
        noBooks++;
        //game over condition
        if(noBooks==13){
            
        }
    }
    
    public int getNoBooks(){
        return noBooks;
    }
    
    //search through deck to find books. 
    public int getBooks(Deck deck){
        int booksScored = 0;
        int ranks[] = new int[13];
        /*for(int i : ranks){
            i = 0;
        }*/
        
        //place amount of rank in array then count books
        for(FCard card : deck.getCards()){
            ranks[card.getValue().getValue()]+=1;
        }
        for(int i : ranks){
            if (i == 4){
                System.out.println("Book found");
                bookScored();
                booksScored++;
            }
        }
        return booksScored;
    }
}
