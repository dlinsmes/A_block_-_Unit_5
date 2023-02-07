public class Deck {

    //this class is a composition because a deck
    //is composed of Card objects
    private Card [] cards;

    //used to track the "top" of the deck as
    //cards are drawn because with the array,
    //cards can't be removed or easily moved around
    private int top;

    public Deck() {
        top = 0;

        //initialize the array size
        cards = new Card[52];

        int index = 0;

        //-use for loops for each suit to generate all card
        //objects to save in the array
        //-use the i variable to iterate through values
        //for each card object
        for (int i = 1; i <= 13; i++) {
            Card c = new Card("Spades", i);
            cards[index] = c;
            index++;
        }
        for (int i = 1; i <= 13; i++) {
            cards[index] = new Card("Hearts", i);
            index++;
        }
        for (int i = 1; i <= 13; i++) {
            cards[index] = new Card("Diamonds", i);
            index++;
        }
        for (int i = 1; i <= 13; i++) {
            cards[index] = new Card("Clubs", i);
            index++;
        }
    }

    public String toString() {
        String s = "";
        for (Card c: cards)
            s += c.toString() + "\n";
        return s;
    }

    //methods can return objects
    public Card draw() {

        Card topCard = cards[top];
        top++;
        return topCard;
    }

    public void shuffle() {

        for (int i = 0; i < 200; i++) {
            int r1 = (int)(Math.random() * 52);
            int r2 = (int)(Math.random() * 52);

            Card temp = cards[r1];
            cards[r1] = cards[r2];
            cards[r2] = temp;
        }

    }

    public int getSize() {
        return 52-top;
    }
}
