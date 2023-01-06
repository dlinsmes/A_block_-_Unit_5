public class Card {
    private String suit;
    private String rank;
    private int value;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
        //turning the value into a string
        rank = "" + value;
        //for face cards, assign the name of the card
        if (value == 1)
            rank = "Ace";
        if (value == 11)
            rank = "Jack";
        if (value == 12)
            rank = "Queen";
        if (value == 13)
            rank = "King";
    }

    public String getSuit() { return suit;}
    public String getRank() { return rank;}
    public int getValue() { return value;}

    public String toString() {
        return rank + " of " + suit;
    }


}
