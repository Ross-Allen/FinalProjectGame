package javafxgame;

import java.util.ArrayList;
/**
 * Deck SubClass
 * @author ross
 */
public class Deck extends GroupOfCards {

    /**
     * Deck Constructor
     */
    public Deck(){
        //Initialize deck ArrayList
        group = new ArrayList<>(52);
        
        //Load deck with standard card deck size of 52 cards
        for(final Suit suit : Suit.values()){
            for(final Number number : Number.values()){
                Card card = new Card(number, suit);
                group.add(card);
            }//end inner
        }//end outer
    }
   
    /**
     * Override toString method
     * @return 
     */
    @Override
    public String toString(){
        String fullString = "";
        for(Card element: group){
            fullString += element.number + " of " + element.suit + ", ";
        }
        return fullString;
    }
}
