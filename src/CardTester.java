public class CardTester {

    public static void main(String [] args) {
        Card c = new Card("Spades", 5);
        System.out.println(c);

        System.out.println();

        Deck d = new Deck();
        System.out.println(d);

        //save the return object from
        //calling the draw method
        Card drawn = d.draw();
        System.out.println(drawn);

        //replace that object with
        //the next drawn card
        drawn = d.draw();
        System.out.println(drawn);


        d.shuffle();
        System.out.println();
        System.out.println(d);
    }

}
