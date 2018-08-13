package javafxgame;

import java.util.ArrayList;
/**
 * Deck SubClass
 * @author ross
 */
public class Deck extends GroupOfCards {
    
    /**
     * Deck collection of cards
     */
    private ArrayList<Card> deck;
    
    /**
     * Deck Constructor
     */
    public Deck(){
        //Initialize deck ArrayList
        deck = new ArrayList<>(52);
        
        //Load deck with standard card deck size of 52 cards
        for(final Suit suit : Suit.values()){
            for(final Number number : Number.values()){
                Card card = new Card(number, suit);
                deck.add(card);
            }//end inner
        }//end outer
    }
    
    /**
     * Get deck method
     * @return ArrayList collection of cards
     */
    public ArrayList<Card> getDeck(){
        return this.deck;
    }
    
    /**
     * Override toString method
     * @return 
     */
    @Override
    public String toString(){
        String fullString = "";
        for(Card element: deck){
            fullString += element.number + " of " + element.suit + ", ";
        }
        return fullString;
    }
}
