package javafxgame;

import java.util.ArrayList;
/**
 * Hand class
 * @author ross
 */
public class Hand extends GroupOfCards{
    
    /**
     * Hand collection of cards 
     */
    private ArrayList<Card> hand;
    
   /**
    * Hand Constructor
    */
    public Hand(){
        hand = new ArrayList<>();
    }
    
    /**
     * Get hand method 
     * @return ArrayList collection of cards
     */
    public ArrayList<Card> getHand(){
        return this.hand;
    }
    
    /**
     * Override toString method
     * @return 
     */
    @Override
    public String toString(){
        String fullString = "";
        for(Card element: this.hand){
            fullString += element.number + " of " + element.suit + ", ";
        }
        return fullString;
    }
}


