package javafxgame;
/**
 * Number enumeration
 * @author ross
 */
public enum Number {
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(11),
    Queen(12),
    King(13),
    Ace(14);

    //Private Attribute
    private final int numValue;

    //private constructor
    private Number(int numberValue){
        this.numValue = numberValue;
    }
    //Access method
    public int getValue(){
        return numValue;
    }
}//end Number enumuration