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
        try{
            Collections.sort(this.group, (a,b)->b.compareTo(a));
        }catch(Exception e){
            System.out.println("Error occured in GroupOfCards.java->order()");
        }  
        
    }
    
    /**
     * dealCard method
     * @return 
     */
    public Card dealCard(){
        try{
            return this.group.remove(0);
        }catch(Exception e){
            System.out.println("Error occured in GroupOfCards.java->dealCard()");
            return null;
        }  
    }
     
    /**
     * abstract toString method defined in deck and hand
     * @return 
     */
    @Override
    abstract public String toString();
   
}//end GroupOfCards class
