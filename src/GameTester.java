public class GameTester {
    public static void main(String [] args) {
        Blackjack b = new Blackjack();
        b.setupRound();
        b.playRound();
        b.calculateWinner();
    }
}
