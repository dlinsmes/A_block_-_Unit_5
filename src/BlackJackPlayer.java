import java.util.ArrayList;

public class BlackJackPlayer {

    private ArrayList<Card> hand;
    private String name;

    //constructor
    public BlackJackPlayer(String name) {

        hand = new ArrayList<Card> ();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //instance methods - methods that the object can call
    public void addCard(Card c) {
        hand.add(c);
    }

    //calculate and return the player's score based on the cards in their hand
    //-calculate optimal score by figuring out the best scenario for any aces
    public int getScore() {

        int aces = 0;
        int score = 0;
        for (int i = 0; i < hand.size(); i++) {
            int value = hand.get(i).getValue();
            if (value >= 2 && value <= 10)
                score += value;
            else if (value > 10)
                score += 10;
            else
                aces++;
        }
        //for all but one ace, count as 1 for score
        //-for the last ace, figure out whether it should be 1 or 11
        //for optimal score

        for (int i = 0; i < aces; i++) {
            if (i != aces-1)
                score += 1;
            else {
                if (score + 11 > 21)
                    score += 1;
                else
                    score += 11;
            }
        }


        return score;
    }

    public void clearHand() {
        //remove all cards from the hand
        for ( int i = hand.size()-1; i >= 0; i--)
            hand.remove(i);
    }

    //return score and cards in hand
    public String toString() {
        return "Name: " + name + "\nScore: " + getScore() + "\n" + hand;
    }

}
