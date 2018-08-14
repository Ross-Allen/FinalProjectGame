package javafxgame;
/**
 * DeckDriver Class
 * @author ross
 */
public class GameOfWar implements Game{
    
    /** Game class level attribute declarations */
    public Hand plr1Hand;
    public Hand plr2Hand;
    public Hand plr1Comparable; 
    public Hand plr2Comparable;
    public Hand plr1WinHand; 
    public Hand plr2WinHand; 
    public Deck deck;
    private static int roundsPlayed = 0;
    private static int rounds = 10;
    
    /**
     * Override initialize method
     */
    @Override
    public void initialize(){
        //initialize all needed values for game play
        plr1Comparable = new Hand();
        plr2Comparable = new Hand();
        plr1WinHand = new Hand();
        plr2WinHand = new Hand();
        plr1Hand = new Hand();
        plr2Hand = new Hand();
        deck = new Deck();
        
        //shuffle the deck
        deck.shuffle();
        
        //split the deck
        splitDeck();
    }
    
    /**
     * Override play method
     */
    @Override
    public void play(){
        //local attributes for game play
        int result;
        int size;
        
        //Play only when number of rounds is not met and hands are still full and playable
        while(plr1Hand.group.size() > 0 && plr2Hand.group.size() > 0 && roundsPlayed < rounds){
            //validate that players hand have sufficient for dealing
            if(plr1Hand.group.size() > 0 && plr2Hand.group.size() > 0){
                //deal cards
                plr1Comparable.group.add(plr1Hand.dealCard());
                plr2Comparable.group.add(plr2Hand.dealCard());
                
                //preform comparison of dealt cards
                result = (plr1Comparable.group.get(0)).compareRank(plr2Comparable.group.get(0));
                
                //set size for loops
                size = plr1Comparable.group.size();
                
                //determine round winner and transfer cards to winner hand
                switch(result){
                    case 1:     //player 1 wins
                        for(int i = 0; i < size; i++){
                            plr1WinHand.group.add(plr1Comparable.group.remove(0));
                            plr1WinHand.group.add(plr2Comparable.group.remove(0));
                        }
                        System.out.println("Player 1 won the round");
                        roundsPlayed++;
                        break;
                    case -1:     //player 2 wins
                        for(int i = 0; i < size; i++){
                            plr2WinHand.group.add(plr1Comparable.group.remove(0));
                            plr2WinHand.group.add(plr2Comparable.group.remove(0));
                        }
                        System.out.println("Player 2 won the round");
                        roundsPlayed++;
                        break;
                    case 0:      //tie (war)
                        war();
                        break;
                    default:
                        System.out.println("Error: two cards did not compare properly");
                        break;
                }//end switch
            pileToHand();
            }else{
                pileToHand();
            }
        }//end while
    }//end play method
    
    /**
     * Override displayWinner method
     */
    @Override
    public void displayWinner(){
       if((plr1WinHand.group.size() + plr1Hand.group.size()) >
               (plr2WinHand.group.size() + plr2Hand.group.size())){
           System.out.println("Player 1 Won");
       }else if((plr1WinHand.group.size() + plr1Hand.group.size()) <
               (plr2WinHand.group.size() + plr2Hand.group.size())){
           System.out.println("Player 2 Won");
       }else{
           System.out.println("It's a tie!");
       }
    }
    
    /**
     * splitDeck method
     */
    public void splitDeck(){
        int size = deck.group.size();
        for(int i = 0; i < size; i++){
            if(i % 2 == 0){
                plr1Hand.group.add(deck.group.remove(0));
            }else{
                plr2Hand.group.add(deck.group.remove(0));
            }
        }
    }
    
    /**
     * War method
     */
    public void war(){
        //local war method attributes
        int result;
        int count = 0;
        
        //Play only when number of rounds is not met and hands are still full and playable
        if(roundsPlayed < rounds ||
                    (plr1Hand.group.size() > 0 && plr1WinHand.group.size() > 0) ||
                    (plr2Hand.group.size() > 0 && plr2WinHand.group.size() > 0)){
            //deal four cards and compare final set
            while(count < 4){
                //look to see if pile needs to be made hand
                if(plr1Hand.group.size() > 0 && plr2Hand.group.size() > 0){
                    plr1Comparable.group.add(plr1Hand.dealCard());
                    plr2Comparable.group.add(plr2Hand.dealCard());
                    count++;
                }else{
                    pileToHand();
                }
            }
            //Display war hands
            System.out.println("Player 1 comparison: " + plr1Comparable.toString());
            System.out.println("Player 2 comparison: " + plr2Comparable.toString());
            
            //perform comparison
            result = (plr1Comparable.group.get(plr1Comparable.group.size()-1))
                    .compareRank(plr2Comparable.group.get(plr2Comparable.group.size()-1));
            //size for loops
            int comparisonSize = plr1Comparable.group.size();
            switch(result){
                case 1:      //player 1 wins war
                    for(int i = 0; i < comparisonSize; i++){
                        plr1WinHand.group.add(plr1Comparable.group.remove(0));
                        plr1WinHand.group.add(plr2Comparable.group.remove(0));
                    }
                    System.out.println("Player 1 won the war");
                    roundsPlayed++;
                    break;
                case -1:      //player 2 wins war
                    for(int i = 0; i < comparisonSize; i++){
                        plr2WinHand.group.add(plr1Comparable.group.remove(0));
                        plr2WinHand.group.add(plr2Comparable.group.remove(0));
                    }
                    System.out.println("Player 2 won the war");
                    roundsPlayed++;
                    break;
                case 0: //tie (war again)
                    war();
                    break;
                default:
                    System.out.println("Error: result is not 1, -1, or 0");
                    break;
            }//end switch
        }
    }//end war method

    /**
     * pileToHand method
     */
    private void pileToHand(){
        if(plr1Hand.group.size() < 1){
            for(int i = 0; i < plr1WinHand.group.size(); i++){
                plr1Hand.group.add(plr1WinHand.group.remove(0));
            }
        }
        if(plr2Hand.group.size() < 1){
            for(int i = 0; i < plr2WinHand.group.size(); i++){
                plr2Hand.group.add(plr2WinHand.group.remove(0));
            }
        }
    }

    /**
     * setRounds method
     * @param rounds 
     */
    public static void setRounds(int rounds) {
        GameOfWar.rounds = rounds;
    }
    
    /**
     * getRoundsPlayed method
     * @return 
     */
    public static int getRoundsPlayed() {
        return roundsPlayed;
    }
    
}//end class
