
import java.util.Scanner;
import java.util.ArrayList;
public class Blackjack {
    private Deck d;
    private ArrayList<BlackJackPlayer> players;
    private Scanner s;

    public Blackjack() {
        d = new Deck();
        players = new ArrayList<BlackJackPlayer>();
        s = new Scanner(System.in);

        System.out.println("How many players?");
        int num = s.nextInt();
        s.nextLine();

        for (int i = 0; i < num; i++) {
            System.out.println("What is the player name?");
            String n = s.nextLine();
            BlackJackPlayer player = new BlackJackPlayer(n);
            players.add(player);
        }

    }

    public void setupRound() {
        d.shuffle();
        for (int i = 0; i < players.size(); i++){
            players.get(i).clearHand();
        }
        for (int i = 0; i < players.size(); i++) {
            Card c = d.draw();
            players.get(i).addCard(c);
        }
        for (BlackJackPlayer p: players)
            p.addCard(d.draw());
    }

    public void playRound() {

        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName() + " - it's your turn");
            System.out.println(players.get(i));
            System.out.println("do you want to hit or stand?");
            String move = s.nextLine();
            while (!move.equals("hit") && !move.equals("stand")) {
                System.out.println("invalid");
                System.out.println("do you want to hit or stand?");
                move = s.nextLine();
            }

            while (players.get(i).getScore() <= 21 && move.equals("hit")){
                players.get(i).addCard(d.draw());
                System.out.println(players.get(i));

                if (players.get(i).getScore() <= 21) {
                    System.out.println("do you want to hit or stand?");
                    move = s.nextLine();

                    while (!move.equals("hit") && !move.equals("stand")) {
                        System.out.println("invalid");
                        System.out.println("do you want to hit or stand?");
                        move = s.nextLine();
                    }
                }
            }
            System.out.println();
        }
    }

    public void calculateWinner() {
        String winners = "";
        int winScore = 0;
        for (BlackJackPlayer p: players) {
            if (p.getScore() > winScore && p.getScore() <= 21) {
                winScore = p.getScore();
                winners += p.getName();
            } else if (p.getScore() == winScore)
                winners += ", " + p.getName();
        }
        System.out.println("winner: " + winners);
        System.out.println("score: " + winScore);



    }


}
