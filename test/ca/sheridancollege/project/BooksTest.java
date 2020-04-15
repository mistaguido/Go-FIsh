/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author REEEE
 */
public class BooksTest {
    
    public BooksTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNoBooks method, of class Books.
     */
    @Test
    public void testGetNoBooksGood() {
        System.out.println("getNoBooks");
        Books instance = new Books();
        ArrayList<FCard> card = new ArrayList();
        for(Suit v : Suit.values()){
            card.add(new FCard(v, Value.KING));
        }
        Deck deck = new Deck(card);
        int expResult = 1;
        int result = instance.getBooks(deck);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetNoBooksNoBad() {
        System.out.println("getNoBooks");
        Books instance = new Books();
        ArrayList<FCard> card = new ArrayList();
        card.add(new FCard(Suit.CLUBS, Value.DEUCE));
        Deck deck = new Deck(card);
        int expResult = 0;
        int result = instance.getBooks(deck);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetNoBooksNoBoundary() {
        System.out.println("getNoBooks");
        Books instance = new Books();
        ArrayList<FCard> card = new ArrayList();
        for(Suit v : Suit.values()){
            card.add(new FCard(v, Value.KING));
        }
        for(Suit v : Suit.values()){
            card.add(new FCard(v, Value.FIVE));
        }
        for(Suit v : Suit.values()){
            card.add(new FCard(v, Value.DEUCE));
        }
        for(Suit v : Suit.values()){
            card.add(new FCard(v, Value.SEVEN));
        }
        Deck deck = new Deck(card);
        int expResult = 4;
        int result = instance.getBooks(deck);
        assertEquals(expResult, result);
    }
}
