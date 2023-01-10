import java.util.ArrayList;

public class BlackJackPlayer {

    private ArrayList<Card> hand;

    //constructor
    public BlackJackPlayer() {
        hand = new ArrayList<Card> ();
    }

    //instance methods - methods that the object can call
    public void addCard(Card c) {
        hand.add(c);
    }

    //calculate and return the player's score based on the cards in their hand
    //-calculate optimal score by figuring out the best scenario for any aces
    public int getScore() {
        return -1;
    }

    public void clearHand() {
        //remove all cards from the hand
        for ( int i = hand.size()-1; i >= 0; i--)
            hand.remove(i);
    }

    //return score and cards in hand
    public String toString() {
        return "Score: " + getScore() + "\n" + hand;
    }

}
