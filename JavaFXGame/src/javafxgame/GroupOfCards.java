package javafxgame;

import java.util.ArrayList;
import java.util.Collections;
/**
 * GroupOfCards abstract SuperClass
 * @author ross
 */
    public abstract class GroupOfCards {
    
     /** Class Attributes */
    protected ArrayList<Card> group;
    
    /**
     * shuffle method
     */
    public void shuffle(){
       Collections.shuffle(this.group);    
    }
    
    /**
     * order method
     */
    public void order(){
        Collections.sort(this.group, (a,b)->b.compareTo(a));
    }
    
    /**
     * dealCard method
     * @return 
     */
    public Card dealCard(){
        return this.group.remove(0);
    }
     
    /**
     * abstract toString method defined in deck and hand
     * @return 
     */
    @Override
    abstract public String toString();
   
}//end GroupOfCards class
