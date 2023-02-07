public class GoFishTester {
    public static void main(String [] args) {

        Deck d = new Deck();

        GoFishPlayer p = new GoFishPlayer("bob");
        p.addCard(d.draw());
        p.addCard(d.draw());
        p.addCard(d.draw());
        p.addCard(d.draw());
        p.addCard(d.draw());

        System.out.println(p.verifyRankRequest("2"));
        System.out.println(p.verifyRankRequest("King"));

        System.out.println(p.giveCards("3"));


        Card c = new Card("Spades", 1);
        p.addCard(c);
        p.addCard(c);

        System.out.println(p.giveCards("Ace"));


        System.out.println(p);

        p.addCard(c);
        p.addCard(c);
        p.addCard(c);
        p.addCard(c);

        GoFishGame game = new GoFishGame();
        game.setupGame();
        game.playGame();
    }
}
