/**
 * Comparable interface for Card Objects
 * @author ross
 * @param <Card> 
 */
public interface Comparable<Card> {
    public int compareTo(Card card2);
    public int compareRank(Card card2);
}
