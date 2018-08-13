package javafxgame;

/**
 * Card Class
 * @author ross
 */
public class Card implements Comparable<Card>{// implements Comparable<Card>
    
    /** Class Attributes */
    protected final Number number;
    protected final Suit suit;
    
    //Rank enumeration
    

    /**
     * Constructor method
     * @param number
     * @param suit 
     */
    public Card(Number number, Suit suit){
        this.number = number;
        this.suit = suit; 
    }
    
    /**
     * Override compareTo method
     * @param card2
     * @return 
     */
    @Override
    public int compareTo(Card card2){
        if((this.number.getValue() + this.suit.getSuit()) >
                (card2.number.getValue() + card2.suit.getSuit())){
            return 1;
        }else if((this.number.getValue() + this.suit.getSuit()) <
                (card2.number.getValue() + card2.suit.getSuit())){
            return -1;
        }else{
            return 0; //Card values are equal
        }
    }
    
    /**
     * compareRank method
     * @param card2
     * @return 
     */
    @Override
    public int compareRank(Card card2){
        if(this.number.getValue() > card2.number.getValue()){
            return 1;
        }else if(this.number.getValue() < card2.number.getValue()){
            return -1;
        }else{
            return 0; //Card values are equal
        }
    }
    
   
    
}//end card class
