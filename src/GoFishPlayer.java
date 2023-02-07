import java.util.ArrayList;

public class GoFishPlayer {
    private ArrayList<Card> hand;
    private int score;
    private String name;

    public GoFishPlayer(String name) {
        this.name = name;
        hand = new ArrayList<Card>();
        score = 0;
    }

    public void addCard(Card c) {
        int index = 0;
        while (index < hand.size() && hand.get(index).getValue() < c.getValue())
            index++;
        hand.add(index, c);
        checkSets();
    }

    private void checkSets() {
        for (int i = 0; i < hand.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < hand.size(); j++)
                if (hand.get(j).getValue() == hand.get(i).getValue())
                    count++;
            if (count == 4) {
                System.out.println("You got a set of " + hand.get(i).getRank() + "s");
                for (int j = 0; j < 4; j++)
                    hand.remove(i);
                score++;
            }
        }
    }

    public ArrayList<Card> giveCards(String rank) {
        ArrayList<Card> toGive = new ArrayList<Card>() ;
        for (int i = 0; i < hand.size(); i++)
            while (hand.size() > 0 && hand.get(i).getRank().equals(rank))
                toGive.add(hand.remove(i));
        return toGive;
    }

    public boolean verifyRankRequest(String rank) {
        for (Card c: hand)
            if (c.getRank().equals(rank))
                return true;
        return false;
    }

    public int getScore() { return score;}
    public String getName() { return name;}

    public boolean needNewCards() { return hand.size() == 0; }

    public String toString() {
        String s = "Your hand:\n";
        for (Card c: hand)
            s += c.toString() + "\n";
        return s;
    }

}
