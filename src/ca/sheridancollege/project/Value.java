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
public enum Value { DEUCE(2), THREE(3), FOUR(4),
    FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
    NINE(9), TEN(10), JACK(11), QUEEN(12),
    KING(13), ACE(14);
    
    private final int value;
    
    Value(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public String toString(){
        switch(value)
        {
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 14:
                return "Ace";
            default:
                break;
        }
        String s = "" + value;
        return s;
    }
}
