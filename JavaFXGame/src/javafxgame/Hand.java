package javafxgame;

import java.util.ArrayList;
/**
 * Hand class
 * @author ross
 */
public class Hand extends GroupOfCards{

   /**
    * Hand Constructor
    */
    public Hand(){
        group = new ArrayList<>();
    }

    /**
     * Override toString method
     * @return 
     */
    @Override
    public String toString(){
        String fullString = "";
        for(Card element: this.group){
            fullString += element.number + " of " + element.suit + ", ";
        }
        return fullString;
    }
}


