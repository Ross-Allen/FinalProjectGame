package javafxgame;
/**
 * Suit enumeration
 * @author ross
 */
public enum Suit {
    Clubs(0),
    Diamonds(13),
    Hearts(26),
    Spades(39);

    //Private Attribute
    private final int suitToString;

    //private constructor
    private Suit(int suitToString){
        this.suitToString = suitToString;
    }
    //Access method
    public int getSuit(){
        return suitToString;
    }
}//end Suit enumeration
